package com.example.springboot.service;

import com.example.springboot.model.Funcionario;
import com.example.springboot.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id).orElse(null);
        if (funcionarioExistente != null) {
            funcionarioExistente.setNome(funcionarioAtualizado.getNome());
            funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
            funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
            funcionarioExistente.setHotel(funcionarioAtualizado.getHotel());
            return funcionarioRepository.save(funcionarioExistente);
        }
        return null;
    }

    public boolean excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null) {
            funcionarioRepository.delete(funcionario);
            return true;
        }
        return false;
    }
}
