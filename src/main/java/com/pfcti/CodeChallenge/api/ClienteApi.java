package com.pfcti.CodeChallenge.api;

import com.pfcti.CodeChallenge.dto.ClienteContactoDto;
import com.pfcti.CodeChallenge.dto.ClienteDto;
import com.pfcti.CodeChallenge.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes(){
        return clienteService.obtenerClientes();
    }

    @GetMapping(value = "/{identificacion}")
    public ClienteDto buscarClientePorIdentificacion(@PathVariable String identificacion){
        return clienteService.obtenerCliente(identificacion);
    }

    @PostMapping
    public void insertarCliente(@RequestBody ClienteDto clienteDto){
        clienteService.insertarCliente(clienteDto);
    }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteContactoDto clienteDto){
        clienteService.actualizarDatosContactoCliente(clienteDto);
    }

    @PutMapping(value = "/inactivar/{id}")
    public void actualizarCliente(@PathVariable Integer id){
        clienteService.inactivarClienteXId(id);
    }
}