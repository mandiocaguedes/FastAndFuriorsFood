/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FastAndFuriorsFood.service;

/**
 *
 * @author sesi3dia
 */
import FastAndFuriorsFood.domain.model.Categoria;
import FastAndFuriorsFood.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new RuntimeException("O nome da categoria é obrigatório.");
        }
        return repository.save(categoria);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        repository.deleteById(id);
    }
}