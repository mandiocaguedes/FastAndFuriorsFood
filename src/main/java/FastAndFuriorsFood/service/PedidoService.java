/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FastAndFuriorsFood.service;

import FastAndFuriorsFood.domain.model.Pedido;
import FastAndFuriorsFood.domain.model.StatusPedido;
import FastAndFuriorsFood.repository.PedidoRepository;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criarPedido(Pedido pedido) {
        // Lógica para gerar número sequencial poderia vir de um contador diário
        return repository.save(pedido);
    }

    public Pedido alterarStatus(Long id, StatusPedido novoStatus) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        return repository.save(pedido);
    }

    public List<Pedido> listarPorStatus(StatusPedido status) {
        return repository.findByStatus(status);
    }

    // Regra dos 14 minutos: Verifica se o pedido está atrasado
    public boolean estaAtrasado(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.ENTREGUE) return false;
        long minutos = Duration.between(pedido.getDataCriacao(), LocalDateTime.now()).toMinutes();
        return minutos > 14;
    }
}
