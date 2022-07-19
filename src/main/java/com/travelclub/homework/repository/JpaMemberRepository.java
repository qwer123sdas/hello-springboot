package com.travelclub.homework.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.travelclub.homework.domain.Member;

public class JpaMemberRepository implements MemberRepository {

	private final EntityManager em; // 데이터 연동 처리를 여기서 다 처리함

	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name).getResultList();
		return result.stream().findAny();
	}

}
