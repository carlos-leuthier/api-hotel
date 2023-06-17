package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Você pode adicionar métodos personalizados do repositório aqui, se necessário
}
