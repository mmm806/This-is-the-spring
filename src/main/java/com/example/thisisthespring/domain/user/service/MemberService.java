package com.example.thisisthespring.domain.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.example.thisisthespring.domain.user.dto.request.MemberRequest;
import com.example.thisisthespring.domain.user.dto.response.MemberResponse;
import com.example.thisisthespring.domain.user.entity.Member;
import com.example.thisisthespring.domain.user.repository.MemberRepository;
import com.example.thisisthespring.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberResponse create(MemberRequest memberRequest) {
		Member member = Member.builder()
			.name(memberRequest.getName())
			.email(memberRequest.getEmail())
			.age(memberRequest.getAge())
			.enabled(true)
			.build();
		memberRepository.save(member);
		return mapToMemberResponse(member);
	}


	public List<MemberResponse> findAll() {
		return memberRepository
			.findAll()
			.stream()
			.map(this::mapToMemberResponse)
			.toList();
	}

	public MemberResponse findById(Long id) {
		Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
		return mapToMemberResponse(member);
	}


	public MemberResponse update(Long id, MemberRequest memberRequest) {
		Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
		member.setName(memberRequest.getName());
		member.setEmail(memberRequest.getEmail());
		member.setAge(memberRequest.getAge());
		memberRepository.save(member);
		return mapToMemberResponse(member);
	}


	public MemberResponse patch(Long id, MemberRequest memberRequest) {
		Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
		if (memberRequest.getName() != null) member.setName(memberRequest.getName());
		if (memberRequest.getEmail() != null) member.setEmail(memberRequest.getEmail());
		if (memberRequest.getAge() != null)	member.setAge(memberRequest.getAge());
		memberRepository.save(member);
		return mapToMemberResponse(member);
	}


	public void deleteById(Long id) {
		Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
		memberRepository.deleteById(id);
	}


	private MemberResponse mapToMemberResponse(Member member) {
		return MemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.email(member.getEmail())
			.age(member.getAge())
			.build();
	}
}
