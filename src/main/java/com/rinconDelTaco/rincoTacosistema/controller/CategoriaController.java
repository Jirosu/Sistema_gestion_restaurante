package com.rinconDelTaco.rincoTacosistema.controller;

import com.rinconDelTaco.rincoTacosistema.persitence.Categoria_productoRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Categoria_producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private Categoria_productoRepository repo;

    @GetMapping("/listar")
    public List<Categoria_producto> listar(){
        return repo.listarCategorias();
    }
}
