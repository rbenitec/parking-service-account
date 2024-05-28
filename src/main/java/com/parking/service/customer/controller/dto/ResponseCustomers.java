package com.parking.service.customer.controller.dto;

import com.parking.service.customer.entities.Usuarios;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class ResponseCustomers extends ResponseDto{
    private List<Usuarios> usuariosDtos;
}
