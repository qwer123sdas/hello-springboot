package com.travelclub.homework.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.travelclub.homework.domain.Member;
import com.travelclub.homework.service.MemberService;

class MemberServiceTest {
	
	//MemberService memberService = new MemberService();
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // MemberService에 있는 것과는 다른 레파지토리
	
	MemberService memberService ;
	MemoryMemberRepository memberRepository ;
	
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStroe();
	}
	
	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("hello");
		// when
		Long saveId = memberService.join(member);
		// then
		Member findMember =  memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		// when
		memberService.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");  // 같은 오류 메세지 확인
		/*
		try {
			memberService.join(member2);
			fail();
		}catch(IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123213");
		}
		*/
		
		// then
	}
	@Test
	void findMembers() {
		
	}
	@Test
	void findOne() {
		
	}

}
