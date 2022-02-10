package com.mint.challenge.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mint.challenge.Dtos.OrderReports;
import com.mint.challenge.Dtos.ServiceResponse;
import com.mint.challenge.service.ReportService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ApplicationController {

	private final ReportService reportService;

	@GetMapping
	@ApiOperation(value = "get all products reports : paginated")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful", response = ServiceResponse.class),
			@ApiResponse(code = 500, message = "internal error - critical!", response = ServiceException.class) })
	public ResponseEntity<ServiceResponse<List<OrderReports>>> getAllProducts(
			@RequestParam(value = "startDate", required = true) LocalDateTime startDate,
			@RequestParam(value = "EndDate", required = true) LocalDateTime EndDate,
			@RequestParam(value = "pageNumber", required = true, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize) {
		ServiceResponse<List<OrderReports>> response = reportService.getOrderReportsDateFilter(startDate, EndDate,
				pageNumber, pageSize);
		return new ResponseEntity<>(response, response.getStatus());
	}

}
