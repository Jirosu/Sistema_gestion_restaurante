package com.rinconDelTaco.rincoTacosistema.persitence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rinconDelTaco.rincoTacosistema.persitence.crud.ProductoCrudRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> listarProductos() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public Producto grabarProducto(Producto p) {
        return productoCrudRepository.save(p);
    }

    public Producto actualizarProducto(Producto producto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String prodJson = objectMapper.writeValueAsString(producto);
        System.out.println(prodJson);

        return productoCrudRepository.save(producto);
    }

    public Optional<Producto> eliminarProducto(String codigo) {

        Optional<Producto> productoOptional = productoCrudRepository.findById(codigo);
        productoOptional.ifPresent(producto -> {
            productoCrudRepository.delete(producto);
        });
        return productoOptional;
    }
}
