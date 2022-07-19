package com.travelclub.homework.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelclub.homework.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
	// JPQL : select m from Member m where m.name = ?
	@Override
	Optional<Member> findByName(String name);
}
