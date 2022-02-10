package com.mint.challenge.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mint.challenge.Dtos.OrderReports;
import com.mint.challenge.Dtos.ProductOrderRequest;
import com.mint.challenge.model.OrderReportEntity;

public class TestHelper {

	public static ProductOrderRequest makeProuctOrderRequest() {
		return ProductOrderRequest.builder().productId(4L).productName("Iphone13").quantity(1L).build();
	}

	public static List<ProductOrderRequest> productsList() {
		return new ArrayList<>(List.of(makeProuctOrderRequest()));
	}

	public static OrderReports createReport() {
		return OrderReports.builder().customerEmail("frank@gmail").customerPhoneNumber("0987").deliveryStatus("done")
				.products(productsList()).build();
	}

	public static OrderReportEntity createEntity() {
		return OrderReportEntity.builder().dateCreated(LocalDateTime.now()).paidDate(LocalDateTime.now())
				.reports(createReport()).build();
	}

}
