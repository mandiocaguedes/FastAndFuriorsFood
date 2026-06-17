/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FastAndFuriorsFood.controller;

import FastAndFuriorsFood.domain.model.Pedido;
import FastAndFuriorsFood.domain.model.StatusPedido;
import FastAndFuriorsFood.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */
@RestController
@RequestMapping("/fastfurious/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listarTodos() {
        return service.listarPorStatus(null);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }

    @GetMapping("/status/{status}")
    public List<Pedido> getByStatus(@PathVariable StatusPedido status) {
        return service.listarPorStatus(status);
    }

    @PutMapping("/status/{id}")
    public Pedido updateStatus(@PathVariable Long id, @RequestBody StatusPedido status) {
        return service.alterarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        service.alterarStatus(id, StatusPedido.CANCELADO);
    }
}