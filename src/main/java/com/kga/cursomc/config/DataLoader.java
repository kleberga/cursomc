package com.kga.cursomc.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kga.cursomc.domain.Categoria;

import jakarta.annotation.PostConstruct;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Component
public class DataLoader {

    private List<Categoria> categorias;

    @PostConstruct
    public void init() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/com/kga/cursomc/resources/data.json");
        JsonNode root = mapper.readTree(is);

        categorias = mapper.convertValue(root.get("categorias"),
                mapper.getTypeFactory().constructCollectionType(List.class, Categoria.class));

    }

    public List<Categoria> loadCategorias() { return categorias; }

}

