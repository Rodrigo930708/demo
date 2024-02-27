package com.demo.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.application.mapper.Mapper;
import com.demo.infraestructure.entity.Prices;

@SpringBootTest
public class PricesRepositoryTest {
	
	@Autowired
	private PricesRepository pricesRepository;

	@Test
	void findByDateProductAndGroup_Test_Ok() {
		
		Date se = Mapper.convertStringDate("2020-06-14 16:00:00");
		
		List<Prices> prices = pricesRepository.findByDateProductAndGroup(35455, 1, se);
		
		assertNotNull(prices);
		assertEquals(2,prices.size());

	}
}
