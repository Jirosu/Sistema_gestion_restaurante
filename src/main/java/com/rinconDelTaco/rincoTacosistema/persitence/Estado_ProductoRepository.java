package com.rinconDelTaco.rincoTacosistema.persitence;

import com.rinconDelTaco.rincoTacosistema.persitence.crud.Estado_ProductoCrudRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Estado_producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Estado_ProductoRepository {
    @Autowired
    private Estado_ProductoCrudRepository estadoProductoCrudRepository;


    public List<Estado_producto> listarEstados() {
        return (List<Estado_producto>)estadoProductoCrudRepository.findAll();
    }
}
