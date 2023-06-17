package com.example.springboot.service;

import com.example.springboot.model.Quarto;
import com.example.springboot.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {
    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public List<Quarto> getAllQuartos() {
        return quartoRepository.findAll();
    }

    public Quarto getQuartoById(Long id) {
        return quartoRepository.findById(id).orElse(null);
    }

    public Quarto createQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto updateQuarto(Long id, Quarto updatedQuarto) {
        Quarto quarto = quartoRepository.findById(id).orElse(null);
        if (quarto != null) {
            quarto.setNumero(updatedQuarto.getNumero());
            quarto.setTipo(updatedQuarto.getTipo());
            quarto.setPrecoDiaria(updatedQuarto.getPrecoDiaria());
            quarto.setHotel(updatedQuarto.getHotel());
            return quartoRepository.save(quarto);
        }
        return null;
    }

    public boolean deleteQuarto(Long id) {
        Quarto quarto = quartoRepository.findById(id).orElse(null);
        if (quarto != null) {
            quartoRepository.delete(quarto);
            return true;
        }
        return false;
    }
}
