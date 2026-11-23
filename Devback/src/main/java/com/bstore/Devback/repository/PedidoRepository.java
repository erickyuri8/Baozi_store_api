package com.bstore.Devback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bstore.Devback.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}