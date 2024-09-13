package com.rinconDelTaco.rincoTacosistema.persitence.crud;

import com.rinconDelTaco.rincoTacosistema.persitence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, String> {
}
