package com.travelclub.homework.service;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travelclub.homework.aop.TimeTraceAop;
import com.travelclub.homework.repository.JdbcMemberRepository;
import com.travelclub.homework.repository.JdbcTemplateMemberRepository;
import com.travelclub.homework.repository.JpaMemberRepository;
import com.travelclub.homework.repository.MemberRepository;
import com.travelclub.homework.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	/*
	private final DataSource dataSource;
	private final EntityManager em;

	public SpringConfig(DataSource dataSource, EntityManager em) {
		this.dataSource = dataSource;
		this.em = em;
	}
	*/
	
	private final MemberRepository memberRepository;
	
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository); // 스프링 빈을 등록하고, 등록되어 잇는 레파지토리를
		// 멤버 서비스에 넣어준다. // 해당 메소드를 리턴했기 떄문에 그 리턴값인 빈을 넣어주게 된다.
	}
	
	
	/*
	@Bean
	public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
		// return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}
	*/
}
