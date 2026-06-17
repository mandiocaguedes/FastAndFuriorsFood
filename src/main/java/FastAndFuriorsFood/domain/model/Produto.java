/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FastAndFuriorsFood.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 *
 * @author sesi3dia
 */
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;

    // Note: Removi a String categoria que você tinha. 
    // No JPA, usamos apenas o objeto da relação.
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // 1. CONSTRUTOR PADRÃO (Obrigatório para o JPA)
    public Produto() {
    }

    // 2. CONSTRUTOR COMPLETO (Útil para criar objetos no Service)
    public Produto(long id, String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    // 3. GETTERS E SETTERS (Essenciais para o Spring converter para JSON)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
        
       
    
        

  