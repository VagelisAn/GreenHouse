package com.example.demo.repository;


import com.example.demo.model.TemperatureHumidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempHumRepository extends JpaRepository<TemperatureHumidity, Long> {
//	List<TemperatureHumidity> findByPublished(boolean published);
//	List<TemperatureHumidity> findByTitleContaining(String title);
}
