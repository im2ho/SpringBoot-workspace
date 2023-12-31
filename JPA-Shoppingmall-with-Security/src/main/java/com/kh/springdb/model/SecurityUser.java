package com.kh.springdb.model;

import java.util.List; //좋아요 기능 구현하려다가;;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class SecurityUser {

	//멤버(필드)변수
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
	@SequenceGenerator(name="users_seq", sequenceName="users_seq", allocationSize=1)
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	//UserRole 부여
	//방법1
	//@Enumerated(EnumType.STRING)
	//private UserRole isRole;
	
	//방법2
	private String isRole;
	
	/*
	//제품에 대한 좋아요를 받고 싶다..
	//추천에 관련된 변수를 추가
	@OneToMany(
            mappedBy = "securityUser",
            cascade = CascadeType.ALL, //User 삭제시 관련된 Heart도 삭제
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Heart> heart;*/
}

