package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem {

	//멤버(필드)변수
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderItem_seq")
	@SequenceGenerator(name="orderItem_seq", sequenceName="orderItem_seq", allocationSize=1)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;
	
	//구매자
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	//상품 주문번호
	private int itemId;
	
	//주문 상품명
	private String itemName;
	
	//주문 상품 가격
	private int itemPrice;
	
	//주문 상품 수량
	private int itemCount;
	
	//가격 * 수량 = 총 가격
	private int itemTotalPrice;
	
	//주문 취소 여부 (1: 주문취소, 0: 주문완료)
	private int isCancel;
	
	//주문 상품에 매핑되는 판매상품
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="saleItem_id")
	private SaleItem saleItem;
	
	//장바구니 상품 '하나씩' 개별 주문하는 메서드
	public static OrderItem createOrderItem(int itemId, User user, Item item, int count, Order order, SaleItem saleItem) {
		
		OrderItem orderItem = new OrderItem();
		
		orderItem.setItemId(itemId);
		orderItem.setUser(user);
		orderItem.setOrder(order);
		
		//아이템 자체가 고유하게 지니는 상품명 및 가격으로 설정 필요(임의지정 X) > getter를 이용한다
		orderItem.setItemName(item.getName());
		orderItem.setItemPrice(item.getPrice());
		
		//어떤 제품을 몇 개 살 것이고, 최종적으로 몇 개를 구매할 것인가?
		orderItem.setItemCount(count);
		orderItem.setItemTotalPrice(item.getPrice() * count);
		orderItem.setSaleItem(saleItem);
		
		return orderItem;
	}
	
	//장바구니 전체 주문
	public static OrderItem createOrderItem(int itemId, User user, CartItem cartItem, SaleItem saleItem) {
		
		OrderItem orderItem = new OrderItem();
		
		orderItem.setItemId(itemId);
		orderItem.setUser(user);
		orderItem.setItemName(cartItem.getItem().getName());
		orderItem.setItemPrice(cartItem.getItem().getPrice());
		orderItem.setItemCount(cartItem.getCount());
		orderItem.setItemTotalPrice(cartItem.getItem().getPrice() * cartItem.getCount());
		orderItem.setSaleItem(saleItem);
		return orderItem;
	}
}
