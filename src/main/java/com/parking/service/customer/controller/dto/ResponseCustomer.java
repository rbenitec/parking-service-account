package com.parking.service.customer.controller.dto;

import com.parking.service.customer.entities.Usuarios;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ResponseCustomer extends ResponseDto{
    private Usuarios usuariosDto;

}
