package com.kh.springdb.model;

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
}
