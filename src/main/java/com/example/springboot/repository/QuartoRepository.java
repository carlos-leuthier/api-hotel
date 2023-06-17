package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Quarto;
@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
