package com.desarrollo.spring.complexivo.repository;

import com.desarrollo.spring.complexivo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
