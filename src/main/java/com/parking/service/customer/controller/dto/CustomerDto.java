package com.parking.service.customer.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CustomerDto {
    private Integer Id;
    private String dni;
    private String rol;
    private String names;
}
