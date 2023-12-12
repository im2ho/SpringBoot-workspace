package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter 
@Setter
@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_seq")
	@SequenceGenerator(name="products_seq", sequenceName="products_seq", allocationSize=1)
	private int id;
	
	private String name;
	
	private String text;
	
	private String price;
	
	private int count;
	
	private int stock;
	
	private int isSoldout;
	
	//댓글 작성을 위한 Comment
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	//제품 이미지를 위한 필드 설정
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
	
	//createDate에 들어갈 날짜자동생성
	public void createDate() {
		this.createDate = LocalDate.now();
	}
}
