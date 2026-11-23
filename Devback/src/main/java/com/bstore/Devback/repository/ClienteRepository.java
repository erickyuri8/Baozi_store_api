package com.bstore.Devback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bstore.Devback.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}