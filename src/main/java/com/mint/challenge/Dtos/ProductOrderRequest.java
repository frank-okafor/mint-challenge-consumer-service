package com.mint.challenge.Dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductOrderRequest {
	private Long productId;
	private Long quantity;
	private String productName;
	private BigDecimal totalAmount;
}
