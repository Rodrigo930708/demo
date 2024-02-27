package com.demo.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.infraestructure.entity.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

	@Query("select u from Prices u where u.productId = ?1 and u.brandId =?2 "
			+ "and u.startDate < ?3 and u.endDate > ?3")
	List<Prices> findByDateProductAndGroup(Integer productId, Integer group, Date fecha);
}
