package com.desarrollo.spring.complexivo.services;

import com.desarrollo.spring.complexivo.models.Product;
import com.desarrollo.spring.complexivo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Guardar el producto
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //Listar productos
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //Actualizar producto
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    //Eliminar producto
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
