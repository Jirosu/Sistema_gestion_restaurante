package com.rinconDelTaco.rincoTacosistema.persitence.crud;

import com.rinconDelTaco.rincoTacosistema.persitence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, String> {
}
