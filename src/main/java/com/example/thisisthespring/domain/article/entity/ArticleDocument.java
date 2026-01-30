package com.example.thisisthespring.domain.article.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Builder;
import lombok.Data;

@Document(collection = "article")
@Data
@Builder
public class ArticleDocument {
	@Id
	private String id;
	private String name;
	private String email;
	@TextIndexed(weight = 2)
	private String title;
	@TextIndexed
	private String description;
	@TextScore
	private Float score;
}
