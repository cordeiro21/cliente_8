package com.company.cliente.service;

import com.company.cliente.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    List<Cliente> listar();

    void apagar(Long id);
}
