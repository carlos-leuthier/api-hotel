package com.example.springboot.service;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Cliente;
import com.example.springboot.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente updatedCliente) {
        Cliente existingCliente = clienteRepository.findById(id).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNome(updatedCliente.getNome());
            existingCliente.setEmail(updatedCliente.getEmail());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return true;
    }
}
