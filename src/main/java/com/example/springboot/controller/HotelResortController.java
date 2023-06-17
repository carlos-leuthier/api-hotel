package com.example.springboot.controller;

import com.example.springboot.model.HotelResort;
import com.example.springboot.service.HotelResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotelresorts")
public class HotelResortController {
    private final HotelResortService hotelResortService;

    @Autowired
    public HotelResortController(HotelResortService hotelResortService) {
        this.hotelResortService = hotelResortService;
    }

    @PostMapping
    public ResponseEntity<HotelResort> createHotelResort(@RequestBody HotelResort hotelResort) {
        HotelResort createdHotelResort = hotelResortService.saveHotelResort(hotelResort);
        return new ResponseEntity<>(createdHotelResort, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HotelResort>> getAllHotelResorts() {
        List<HotelResort> hotelResorts = hotelResortService.getAllHotelResorts();
        return new ResponseEntity<>(hotelResorts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResort> getHotelResortById(@PathVariable Long id) {
        Optional<HotelResort> hotelResort = hotelResortService.getHotelResortById(id);
        return hotelResort.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelResort(@PathVariable Long id) {
        hotelResortService.deleteHotelResort(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
