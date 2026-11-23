package com.bstore.Devback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bstore.Devback.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}