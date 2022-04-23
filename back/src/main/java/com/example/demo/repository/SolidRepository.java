package com.example.demo.repository;


import com.example.demo.model.Solid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolidRepository extends JpaRepository<Solid, Long> {
//	List<Solid> findByPublished(boolean published);
//	List<Solid> findByTitleContaining(String title);
}
