package com.mint.challenge.service;

import java.time.LocalDateTime;
import java.util.List;

import com.mint.challenge.Dtos.OrderReports;
import com.mint.challenge.Dtos.ServiceResponse;

public interface ReportService {

	ServiceResponse<List<OrderReports>> getOrderReportsDateFilter(LocalDateTime startDate, LocalDateTime endDate,
			Integer pageNumber, Integer pageSize);

}
