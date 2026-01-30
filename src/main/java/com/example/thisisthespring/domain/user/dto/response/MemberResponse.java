package com.example.thisisthespring.domain.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponse {
	private Long id;
	private String name;
	private String email;
	private Integer age;
}
