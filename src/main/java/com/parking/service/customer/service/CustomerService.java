package com.parking.service.customer.service;

import com.parking.service.customer.controller.dto.CustomerDto;
import com.parking.service.customer.entities.Usuarios;

import java.util.List;

public interface CustomerService{
    CustomerDto createdCustomer(Usuarios usuarios);
    CustomerDto updateCustomer(Usuarios usuarios);
    void deleteCustomer(Integer idCustomer);
    CustomerDto readOnlyCustomer(Integer idCustomer);
    List<CustomerDto> readAllCustomer();

}
