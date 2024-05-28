package com.parking.service.customer.client;

import com.parking.service.customer.controller.dto.RequestDto;
import com.parking.service.customer.controller.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApiClient {

    private final RestTemplate restTemplate;

    @Value("${config.api.document.url}")
    private String url;


    public Optional<ResponseDto> getConsultDocument(RequestDto requestDto) {

        HttpHeaders headers = new HttpHeaders();

        headers.set("x-user-id", "43839339");
        headers.set("x-consumer-id", "landingPasivos");
        headers.set("x-consumer-correlation-id", "d610c30d4-71e1");
        headers.set("x-consumer-request-id", "51f2b61f-fe38-41e7");
        headers.set("x-transaction-id", "landingpasivos.aperturacuentadigital-1708374235-d861bdac-6c24-4f59-9c4c-e1bb65277ee1");
        headers.set("x-caller-id", "/party/customerProfile/v1/buscarPorDocumento");
        headers.set("x-correlation-id", "ed21c817-3701-4816-afbd-790d75e423c");
        headers.set("x-request-id", "3d9ad627-1ac4-41e0");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept","application/json");

        HttpEntity<RequestDto> requestEntity = new HttpEntity<>(requestDto, headers);
        try {

            ResponseEntity<ResponseDto> responseEntity =
                    restTemplate.exchange(url, HttpMethod.POST, requestEntity, ResponseDto.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return Optional.ofNullable(responseEntity.getBody());
            } else {
                log.error("Error en la solicitud: {}", responseEntity.getStatusCode());
            }
        } catch (Exception e) {
            log.error("Error while getting la consulta del documento", e);
        }
        return Optional.empty();
    }
}
