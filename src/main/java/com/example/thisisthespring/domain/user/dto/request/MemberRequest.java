package com.example.thisisthespring.domain.user.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberRequest {
	private String name;
	private String email;
	private Integer age;
}
