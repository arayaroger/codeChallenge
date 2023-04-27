package com.pfcti.CodeChallenge.service;

import com.pfcti.CodeChallenge.dto.ClienteDto;
import com.pfcti.CodeChallenge.model.Cliente;
import com.pfcti.CodeChallenge.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<ClienteDto> obtenerClientes(){
        List<ClienteDto>  clienteReturn = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach( cliente ->{
                    clienteReturn.add(fromClienteToClienteDto(cliente));
                }
        );
        return clienteReturn;
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

}
