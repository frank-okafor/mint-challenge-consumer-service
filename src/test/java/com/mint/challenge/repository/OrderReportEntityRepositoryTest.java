package com.mint.challenge.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.mint.challenge.model.OrderReportEntity;
import com.mint.challenge.service.impl.ReportServiceImpl;
import com.mint.challenge.util.TestHelper;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
@TestInstance(Lifecycle.PER_CLASS)
class OrderReportEntityRepositoryTest {

	@Autowired
	private OrderReportEntityRepository OrderReportEntityRepository;

	@BeforeEach
	void setUp() throws Exception {
		OrderReportEntityRepository.deleteAll();
	}

	@Test
	void testFindAllByPaidDateBetween() throws ParseException {
		LocalDateTime start = LocalDateTime.parse("2022-09-05T11:50:55");
		LocalDateTime end = LocalDateTime.parse("2022-11-05T11:50:55");
		OrderReportEntity entity = TestHelper.createEntity();
		entity = OrderReportEntityRepository.save(entity);
		List<OrderReportEntity> result = OrderReportEntityRepository.findAllByPaidDateBetween(start, end,
				ReportServiceImpl.getPage(1, 3));
		assertThat(result.isEmpty()).isFalse();
	}

}
