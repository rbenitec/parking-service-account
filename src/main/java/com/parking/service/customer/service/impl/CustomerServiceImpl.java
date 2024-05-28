package com.parking.service.customer.service.impl;

import com.parking.service.customer.controller.dto.CustomerDto;
import com.parking.service.customer.entities.Usuarios;
import com.parking.service.customer.repository.CustomerRepository;
import com.parking.service.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto createdCustomer(Usuarios request) {
        Usuarios usuariosResponse = customerRepository.save(request);
        return CustomerDto.builder()
                .Id(usuariosResponse.getId())
                .dni(usuariosResponse.getDni())
                .rol(usuariosResponse.getRol())
                .names(usuariosResponse.getNames())
                .build();

    }

    @Override
    public CustomerDto updateCustomer(Usuarios request) {
        Usuarios usuariosResponse = customerRepository.save(request);
        return CustomerDto.builder()
                .Id(usuariosResponse.getId())
                .dni(usuariosResponse.getDni())
                .rol(usuariosResponse.getRol())
                .names(usuariosResponse.getNames())
                .build();
    }

    @Override
    public void deleteCustomer(Integer idCustomer) {
        customerRepository.deleteById(idCustomer);
    }

    @Override
    public CustomerDto readOnlyCustomer(Integer idCustomer) {
         Optional<Usuarios> customer = customerRepository.findById(idCustomer);
         if(customer.isPresent()){
             return CustomerDto.builder()
                     .Id(customer.get().getId())
                     .names(customer.get().getNames())
                     .rol(customer.get().getRol())
                     .dni(customer.get().getDni())
                     .build();
         }
         return null;
    }

    @Override
    public List<CustomerDto> readAllCustomer() {
        List<Usuarios> usuarios =  customerRepository.findAll();
        if(!usuarios.isEmpty()){
            List<CustomerDto> customerDtos = new ArrayList<>();
            usuarios.forEach(customer1 -> {
                CustomerDto customerDto = CustomerDto.builder()
                        .Id(customer1.getId())
                        .dni(customer1.getDni())
                        .rol(customer1.getRol())
                        .names(customer1.getNames())
                        .build();
                customerDtos.add(customerDto);
            });
            return customerDtos;
        }
        return null;
    }

}
