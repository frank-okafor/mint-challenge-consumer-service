package com.mint.challenge.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mint.challenge.model.OrderReportEntity;

@Repository
@Transactional
public interface OrderReportEntityRepository extends JpaRepository<OrderReportEntity, Long> {
	List<OrderReportEntity> findAllByPaidDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable page);

}
