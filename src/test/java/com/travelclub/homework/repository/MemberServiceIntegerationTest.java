package com.travelclub.homework.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.travelclub.homework.domain.Member;
import com.travelclub.homework.service.MemberService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 디비에 넣었던 데이터를 모두 롤백함
class MemberServiceIntegerationTest {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test //@Commit 을 사용하면 @Transactional을 해도 db에 데이터가 들어가게 된다.
	public void 회원가입() throws Exception {
		// Given
		Member member = new Member();
		member.setName("hello!!!!!1");
		// When
		Long saveId = memberService.join(member);
		// Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() throws Exception {
		// Given
		Member member1 = new Member();
		member1.setName("hello");
		Member member2 = new Member();
		member2.setName("spring2");
		// When
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 예외가
																												// 발생해야
																												// 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}

}
