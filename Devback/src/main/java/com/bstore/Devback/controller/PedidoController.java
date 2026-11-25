package com.bstore.Devback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bstore.Devback.model.Pedido;
import com.bstore.Devback.repository.PedidoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}