package com.example.springboot.controller;

import org.springframework.web.bind.annotation.*;

import com.example.springboot.model.Quarto;
import com.example.springboot.service.QuartoService;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping
    public List<Quarto> getAllQuartos() {
        return quartoService.getAllQuartos();
    }

    @GetMapping("/{id}")
    public Quarto getQuartoById(@PathVariable Long id) {
        return quartoService.getQuartoById(id);
    }

    @PostMapping
    public Quarto createQuarto(@RequestBody Quarto quarto) {
        return quartoService.createQuarto(quarto);
    }

    @PutMapping("/{id}")
    public Quarto updateQuarto(@PathVariable Long id, @RequestBody Quarto updatedQuarto) {
        return quartoService.updateQuarto(id, updatedQuarto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuarto(@PathVariable Long id) {
        return quartoService.deleteQuarto(id);
    }
}
