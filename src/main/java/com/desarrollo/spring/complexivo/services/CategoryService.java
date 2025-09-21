package com.desarrollo.spring.complexivo.services;

import com.desarrollo.spring.complexivo.models.Category;
import com.desarrollo.spring.complexivo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();  //lista de categorías
    }
}
