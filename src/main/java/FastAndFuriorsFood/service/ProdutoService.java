/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FastAndFuriorsFood.service;

import FastAndFuriorsFood.domain.model.Produto;
import FastAndFuriorsFood.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author sesi3dia
 */
@Service
public class ProdutoService {
    
@Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public Produto salvar(Produto produto) {
        if (produto.getPreco().doubleValue() <= 0) {
            throw new RuntimeException("O preço deve ser maior que zero.");
        }
        return repository.save(produto);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
