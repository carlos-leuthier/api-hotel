package com.example.springboot.service;

import com.example.springboot.model.HotelResort;
import com.example.springboot.repository.HotelResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelResortService {
    private final HotelResortRepository hotelResortRepository;

    @Autowired
    public HotelResortService(HotelResortRepository hotelResortRepository) {
        this.hotelResortRepository = hotelResortRepository;
    }

    public HotelResort saveHotelResort(HotelResort hotelResort) {
        return hotelResortRepository.save(hotelResort);
    }

    public List<HotelResort> getAllHotelResorts() {
        return hotelResortRepository.findAll();
    }

    public Optional<HotelResort> getHotelResortById(Long id) {
        return hotelResortRepository.findById(id);
    }

    public void deleteHotelResort(Long id) {
        hotelResortRepository.deleteById(id);
    }
}
