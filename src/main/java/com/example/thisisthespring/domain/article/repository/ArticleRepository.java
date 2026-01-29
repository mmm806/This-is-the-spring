package com.example.thisisthespring.domain.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thisisthespring.domain.article.entity.Article;
import com.example.thisisthespring.domain.user.entity.Member;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByMember(Member member);
}
