package com.company.cliente.controller;

import com.company.cliente.model.Cliente;
import com.company.cliente.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest
class ClienteControllerTest {

    @MockBean
    ClienteServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void clientePOSTControllerTest() throws Exception {

        when(service.salvar(any(Cliente.class))).thenReturn(mockCliente());

        Cliente cliente = new Cliente("Foo");
        String json = "{\"name\":\"Foo\"}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is(cliente.getNome())))
                .andReturn();
    }

    @Test
    void clienteGETControllerTest() throws Exception {

        when(service.listar()).thenReturn(mockClientes());

        List<Cliente> clientes = Arrays.asList(new Cliente("Foo"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome", is(clientes.get(0).getNome())))
                .andReturn();
    }

    private Cliente mockCliente() {
        return new Cliente("Foo");
    }

    private List<Cliente> mockClientes() {
        return Arrays.asList(new Cliente("Foo"));
    }

}