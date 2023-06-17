package com.example.springboot.repository;


import com.example.springboot.model.HotelResort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelResortRepository extends JpaRepository<HotelResort, Long> {
 
}
