package com.example.thisisthespring.domain.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thisisthespring.domain.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryDslRepository {
	List<Product> findByTitleContaining(String title);
	List<Product> findByDescriptionContaining(String description);
}
