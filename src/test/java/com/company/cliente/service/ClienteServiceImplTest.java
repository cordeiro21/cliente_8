package com.company.cliente.service;

import com.company.cliente.model.Cliente;
import com.company.cliente.repository.ClienteRepository;
import com.company.cliente.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {


    @Mock
    ClienteRepository repository;

    private ClienteServiceImpl service;

    @BeforeEach
    public void setup() {
        service = new ClienteServiceImpl(repository);
    }

    @Test
    void shouldReturnClienteWhenSave(){
        when(repository.save(any(Cliente.class))).thenReturn(mockCliente());
        Cliente actual = service.salvar(new Cliente("Foo"));
        Assertions.assertEquals("Foo", actual.getNome() );
    }

    @Test
    void shouldReturnClienteWhenFind(){
        when(repository.findAll()).thenReturn(mockClientes());
        List<Cliente> actual = service.listar();
        Assertions.assertEquals("Foo", actual.get(0).getNome() );
    }

    private Cliente mockCliente() {
        return new Cliente("Foo");
    }

    private List<Cliente> mockClientes() {
        return Arrays.asList(new Cliente("Foo"));
    }
}
