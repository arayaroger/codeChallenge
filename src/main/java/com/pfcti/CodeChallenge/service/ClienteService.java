package com.pfcti.CodeChallenge.service;
import java.util.Optional;
import java.util.Optional.*;

import com.pfcti.CodeChallenge.dto.ClienteContactoDto;
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

    private Cliente fromClienteDtoToCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);
        return cliente;
    }

    public ClienteDto obtenerCliente(String identificacion){
        Cliente cliente = clienteRepository.findClienteByIdentificacion(identificacion);

        if (cliente == null){
            throw new RuntimeException("Cliente No existe");
        };

        return fromClienteToClienteDto(cliente);
    }

    public void insertarCliente(ClienteDto clienteDto){
        clienteRepository.save(fromClienteDtoToCliente(clienteDto));
    }

    public void actualizarDatosContactoCliente(ClienteContactoDto clienteContactoDto){

        Cliente cliente = clienteRepository.findClienteByIdentificacion(clienteContactoDto.getIdentificacion());
        if (cliente == null){
            throw new RuntimeException("Cliente No existe");
        };

        cliente.setDireccionDomicilio(clienteContactoDto.getDireccionDomicilio());
        cliente.setPaisResidencia(clienteContactoDto.getPaisResidencia());
        cliente.setTelefonoContacto(clienteContactoDto.getTelefonoContacto());

        clienteRepository.save(cliente);
    }

    public void inactivarClienteXId(Integer clienteId){
        clienteRepository.setInactiveClienteById(clienteId);

    }


}
