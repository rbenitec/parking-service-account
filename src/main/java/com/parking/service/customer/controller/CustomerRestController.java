package com.parking.service.customer.controller;

import com.parking.service.customer.controller.dto.CustomerDto;
import com.parking.service.customer.controller.dto.RequestDto;
import com.parking.service.customer.entities.Usuarios;
import com.parking.service.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;
    /**
     * Crud Usuarios
     */
    @PostMapping("/created")
    public ResponseEntity<CustomerDto> createdCustomer(@RequestBody RequestDto requestDto) {
        Usuarios usuarios =  new Usuarios();
        usuarios.setNames(requestDto.getNames());
        usuarios.setRol(requestDto.getRol());
        usuarios.setDni(requestDto.getDni());
        CustomerDto customerDto =  customerService.createdCustomer(usuarios);
        if(customerDto!=null){
            return ResponseEntity.ok(customerDto);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/update")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody RequestDto requestDto) {
        Usuarios usuarios =  new Usuarios();
        usuarios.setNames(requestDto.getNames());
        usuarios.setRol(requestDto.getRol());
        usuarios.setDni(requestDto.getDni());
        CustomerDto customerDto =  customerService.updateCustomer(usuarios);
        if(customerDto!=null){
            return ResponseEntity.ok(customerDto);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{idCustomer}")
    public void deleteCustomer(@PathVariable("idCustomer") Integer idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }
    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerDto> readOnlyCustomer(@PathVariable("idCustomer") Integer idCustomer) {
        CustomerDto customerDto = customerService.readOnlyCustomer(idCustomer);
        if(customerDto!=null){
            return ResponseEntity.ok(customerDto);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> readAllCustomer() {
        List<CustomerDto> customers =  customerService.readAllCustomer();
        if(!customers.isEmpty()){
            return ResponseEntity.ok(customers);
        }
        return ResponseEntity.notFound().build();
    }
}
