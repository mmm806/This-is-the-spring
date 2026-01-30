package com.example.thisisthespring.domain.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.thisisthespring.domain.user.dto.request.MemberRequest;
import com.example.thisisthespring.domain.user.dto.response.MemberResponse;
import com.example.thisisthespring.domain.user.entity.Member;
import com.example.thisisthespring.domain.user.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MemberResponse post(@RequestBody MemberRequest memberRequest) {
		return memberService.create(memberRequest);
	}

	@GetMapping
	public List<MemberResponse> getAll() {
		return memberService.findAll();
	}

	@GetMapping("/{id}")
	public MemberResponse get(@PathVariable("id") Long id) {
		return memberService.findById(id);
	}

	@PutMapping("/{id}")
	public MemberResponse put(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
		return memberService.update(id,memberRequest);
	}

	@PatchMapping("/{id}")
	public MemberResponse patch(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
		return memberService.patch(id, memberRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		memberService.deleteById(id);
	}
}
