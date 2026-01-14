package com.example.thisisthespring.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.thisisthespring.domain.user.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
