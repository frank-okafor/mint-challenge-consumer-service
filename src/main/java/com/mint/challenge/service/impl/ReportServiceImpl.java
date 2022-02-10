package com.mint.challenge.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mint.challenge.Dtos.OrderReports;
import com.mint.challenge.Dtos.ServiceResponse;
import com.mint.challenge.repository.OrderReportEntityRepository;
import com.mint.challenge.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	private final OrderReportEntityRepository orderReportEntityRepository;

	@Override
	public ServiceResponse<List<OrderReports>> getOrderReportsDateFilter(LocalDateTime startDate, LocalDateTime endDate,
			Integer pageNumber, Integer pageSize) {
		List<OrderReports> result = orderReportEntityRepository
				.findAllByPaidDateBetween(startDate, endDate, getPage(pageNumber, pageSize)).parallelStream()
				.map(entity -> entity.getReports()).collect(Collectors.toList());
		return new ServiceResponse<List<OrderReports>>(HttpStatus.OK, "records retrieved successfully", result);
	}

	public static Pageable getPage(int pageNumber, int pageSize) {
		Sort sort = Sort.by(Sort.Order.desc("dateCreated").ignoreCase());
		pageNumber = pageNumber == 0 ? 1 : pageNumber;
		pageSize = pageSize == 0 ? 10 : pageSize;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
		return pageable;
	}

}
