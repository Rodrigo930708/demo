package com.demo.application.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.application.exception.MalformedException;
import com.demo.application.response.PricesResponse;
import com.demo.infraestructure.entity.Prices;
import com.demo.infraestructure.enums.Currency;

@SpringBootTest
public class MapperTest {

	@Test
	void convertStringDate_Test_Ok() {
		
		Date se = Mapper.convertStringDate("2020-06-14 16:00:00");
		assertNotNull(se);
	}
	
	@Test
	void convertStringDate_Test_MalformedException() {
		
	    assertThrows(MalformedException.class, () -> Mapper.convertStringDate("2020-06 16:00:00"));
	}
	
	@Test
	void convertResponse_Test_Ok() {
		Prices prices = new Prices();
		prices.setBrandId(1);
		prices.setCurrency(Currency.EUR);
		prices.setEndDate(new Date());
		prices.setPrice(new BigDecimal(53.50));
		prices.setPricelist(3455);
		prices.setPriority(1);
		prices.setProductId(2234);
		prices.setStartDate(new Date());
		
		PricesResponse se = Mapper.convertResponse(prices);
		assertNotNull(se);
	}
}
