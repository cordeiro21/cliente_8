package com.company.cliente.controller;

import com.company.cliente.dto.ClienteDTO;
import com.company.cliente.model.Cliente;
import com.company.cliente.service.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClienteController {

    private final ClienteServiceImpl service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Cliente salvar(@RequestBody ClienteDTO dto) {
        return service.salvar(new Cliente(dto.getNome()));
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable String id) {
        Long codigo = Long.parseLong(id);
        service.apagar(codigo);
    }
}