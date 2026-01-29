package com.example.thisisthespring.domain.product.repository;

import java.util.List;

import com.example.thisisthespring.domain.product.entity.Product;

public interface ProductQueryDslRepository {
	enum SearchType {
		TITLE,
		DESCRIPTION,
		BOTH
	}
	List<Product> queryByKeyword(String keyword,
		SearchType searchType,
		long offset, long limit);
}
