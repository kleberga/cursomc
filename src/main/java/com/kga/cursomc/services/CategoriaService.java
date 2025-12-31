package com.kga.cursomc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kga.cursomc.domain.Categoria;
import com.kga.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    public Categoria buscarCategoria(Integer id) {
        return repository.findById(id)
                         .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void adicionarCategoria(Categoria categoria) {
        // Example business rule: name must not be empty
        if (categoria.getNome() == null || categoria.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório");
        }
        repository.save(categoria);
    }
}

