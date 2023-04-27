package com.pfcti.CodeChallenge.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClienteDto {
    private  int id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String paisResidencia;
    private String paisNacimiento;
    private String direccionDomicilio;
    private String telefonoContacto;
    private Boolean estado;
}
