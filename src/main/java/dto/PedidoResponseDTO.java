/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


import FastAndFuriorsFood.domain.model.StatusPedido;
import java.time.LocalDateTime;
import java.util.List;


public class PedidoResponseDTO {
    private Long id;
    private Integer numeroSequencial;
    private StatusPedido status;
    private LocalDateTime dataCriacao;
    private boolean atrasado; // Lógica dos 14 minutos
    private List<ItemPedidoResponseDTO> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(Integer numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtrasado() {
        return atrasado;
    }

    public void setAtrasado(boolean atrasado) {
        this.atrasado = atrasado;
    }

    public List<ItemPedidoResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoResponseDTO> itens) {
        this.itens = itens;
    }
    
    
}
