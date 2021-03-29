package com.company.cliente.service.impl;

import com.company.cliente.model.Cliente;
import com.company.cliente.repository.ClienteRepository;
import com.company.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    @Override
    public List<Cliente> listar(){
        return repository.findAll();
    }

    @Override
    public void apagar(Long id){
        repository.deleteById(id);
    }
}
