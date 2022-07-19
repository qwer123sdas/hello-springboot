package com.travelclub.homework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity   // jpa가 관리하는 entity가됨
public class Member { 
	// id는 pk, generatedValue는 db에서 아이디를 자동 생성하는 것을 identity전략이라고 함
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}	
