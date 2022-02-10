package com.mint.challenge.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mint.challenge.Dtos.OrderReports;
import com.mint.challenge.model.OrderReportEntity;
import com.mint.challenge.repository.OrderReportEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaListenerSource {
	private final OrderReportEntityRepository orderReportEntityRepository;

	@KafkaListener(topics = "order-topic-new", groupId = "order-reports-001")
	void listen(OrderReports data) {
		OrderReportEntity order = new OrderReportEntity();
		order.setDateCreated(data.getDateCreated());
		order.setPaidDate(data.getPaidDate());
		order.setReports(data);
		orderReportEntityRepository.save(order);
	}

}
