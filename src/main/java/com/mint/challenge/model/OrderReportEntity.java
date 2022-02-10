package com.mint.challenge.model;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mint.challenge.Dtos.OrderReports;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_reports")
@Setter
@Getter
@ToString
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OrderReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_date")
	private LocalDateTime dateCreated;

	@Column(name = "paid_date")
	private LocalDateTime paidDate;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb", name = "order_report")
	@Basic(fetch = FetchType.LAZY)
	private OrderReports reports;

}
