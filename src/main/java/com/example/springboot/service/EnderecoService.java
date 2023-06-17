package com.example.springboot.service;

import com.example.springboot.model.Endereco;
import com.example.springboot.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

  
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEndereco(Long id, Endereco endereco) {
        Endereco existingEndereco = enderecoRepository.findById(id).orElse(null);
        if (existingEndereco != null) {
            existingEndereco.setRua(endereco.getRua());
            existingEndereco.setCidade(endereco.getCidade());
            existingEndereco.setEstado(endereco.getEstado());
            existingEndereco.setCep(endereco.getCep());
            return enderecoRepository.save(existingEndereco);
        }
        return null;
    }

    public boolean deleteEndereco(Long id) {
        Endereco existingEndereco = enderecoRepository.findById(id).orElse(null);
        if (existingEndereco != null) {
            enderecoRepository.delete(existingEndereco);
            return true;
        }
        return false;
    }
}
