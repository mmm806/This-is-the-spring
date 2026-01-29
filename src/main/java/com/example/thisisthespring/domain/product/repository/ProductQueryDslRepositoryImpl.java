package com.example.thisisthespring.domain.product.repository;

import static com.example.thisisthespring.domain.product.entity.QProduct.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.thisisthespring.domain.product.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductQueryDslRepositoryImpl implements ProductQueryDslRepository{

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Product> queryByKeyword(String keyword, SearchType searchType, long offset, long limit) {
		var query = jpaQueryFactory.selectFrom(product);
		switch (searchType) {
			case TITLE:
				query = query.where(product.title.contains(keyword));
				break;
			case DESCRIPTION:
				query = query.where(product.description.contains(keyword));
				break;
			case BOTH:
				query = query.where(product.title.contains(keyword).or(product.description.contains(keyword)));
				break;
		}
		return query.orderBy(product.id.desc())
			.offset(offset)
			.limit(limit)
			.fetch();
	}
}
