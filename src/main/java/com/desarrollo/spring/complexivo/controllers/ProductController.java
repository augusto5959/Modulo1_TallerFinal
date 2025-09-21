package com.desarrollo.spring.complexivo.controllers;

import com.desarrollo.spring.complexivo.models.Product;
import com.desarrollo.spring.complexivo.services.CategoryService;
import com.desarrollo.spring.complexivo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model, Authentication authentication){
        //Obtener el rol del usuario autenticado
        String role = authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(","));
        model.addAttribute("role", role);
        model.addAttribute("products", productService.getAllProducts());
        return "product/home";
    }

    @GetMapping("/add-product")
    public String getFormProduct(@ModelAttribute Product product, Model model){
        //Enviar a la vista la lista de categorías
        model.addAttribute("categories", categoryService.getAllCategories());
        //model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String getFormProductEdit(@PathVariable Long id, Model model){
        //Capturando el producto con el id que coincide
        Product product = productService.getProductById(id).orElseThrow();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/add-product";
    }

    @PostMapping("/product/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product){
        product.setId(id); //Modificar por el id de la url (TEMAS DE SEGURIDAD)
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }

}
