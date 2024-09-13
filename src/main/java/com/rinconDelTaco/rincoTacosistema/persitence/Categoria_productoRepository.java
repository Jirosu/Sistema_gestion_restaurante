package com.rinconDelTaco.rincoTacosistema.persitence;

import com.rinconDelTaco.rincoTacosistema.persitence.crud.Categoria_productoCrudRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Categoria_producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Categoria_productoRepository {
    @Autowired
    private Categoria_productoCrudRepository categoriaProductoCrudRepository;


    public List<Categoria_producto> listarCategorias() {
        return (List<Categoria_producto>)categoriaProductoCrudRepository.findAll();
    }

}
