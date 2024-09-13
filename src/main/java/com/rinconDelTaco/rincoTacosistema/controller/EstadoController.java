package com.rinconDelTaco.rincoTacosistema.controller;

import com.rinconDelTaco.rincoTacosistema.persitence.Estado_ProductoRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Estado_producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private Estado_ProductoRepository repo;

    @GetMapping("/listar")
    public List<Estado_producto> listar(){
        return repo.listarEstados();
    }
}
