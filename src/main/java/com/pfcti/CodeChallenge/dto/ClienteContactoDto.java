package com.pfcti.CodeChallenge.dto;

import lombok.Data;


    @Data
    public class ClienteContactoDto {
        private  int id;
        private String identificacion;
        private String paisResidencia;
        private String direccionDomicilio;
        private String telefonoContacto;
    }

