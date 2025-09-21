package com.desarrollo.spring.complexivo.repository;

import com.desarrollo.spring.complexivo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
