package com.travelclub.homework.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travelclub.homework.repository.MemberRepository;
import com.travelclub.homework.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());  // 스프링 빈을 등록하고, 등록되어 잇는 레파지토리를 
		 // 멤버 서비스에 넣어준다. // 해당 메소드를 리턴했기 떄문에 그 리턴값인 빈을 넣어주게 된다.
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
