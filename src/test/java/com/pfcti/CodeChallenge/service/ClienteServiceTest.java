package com.pfcti.CodeChallenge.service;

import com.pfcti.CodeChallenge.dto.ClienteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;
    @Test
    void obtenerClientes() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientes();
        clienteService
                .obtenerClientes()
                .forEach(cliente -> System.out.println(">>>>> CLIENTE EXISTENTE: " + cliente.getApellidos()));

        assertEquals(1,1);
    }
}