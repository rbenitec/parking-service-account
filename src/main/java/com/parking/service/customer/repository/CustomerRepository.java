package com.parking.service.customer.repository;

import com.parking.service.customer.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Usuarios, Integer> {
}
