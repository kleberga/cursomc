package com.kga.cursomc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kga.cursomc.config.DataLoader;
import com.kga.cursomc.domain.Categoria;

@Repository
public class CategoriaRepository {

    private final List<Categoria> entities;

    public CategoriaRepository(DataLoader loader) {
        this.entities = loader.loadCategorias(); // load from JSON or DB
    }

    public List<Categoria> findAll() {
        return entities;
    }

    public Optional<Categoria> findById(Integer id) {
        return entities.stream()
                       .filter(e -> e.getId().equals(id))
                       .findFirst();
    }

    public void save(Categoria categoria) {
        entities.add(categoria);
    }

    public void deleteById(Long id) {
        entities.removeIf(e -> e.getId().equals(id));
    }
}


