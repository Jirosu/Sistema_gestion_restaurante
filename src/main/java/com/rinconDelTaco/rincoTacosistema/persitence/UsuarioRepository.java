package com.rinconDelTaco.rincoTacosistema.persitence;

import com.rinconDelTaco.rincoTacosistema.persitence.crud.UsuarioCrudRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Producto;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarUsuarios() {
        return (List<Usuario>)usuarioCrudRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario u) {
        u.setContrasena(passwordEncoder.encode(u.getContrasena()));
        return usuarioCrudRepository.save(u);
    }

    public Optional<Usuario> obtenerUsuario(String codigo) {
        return usuarioCrudRepository.findById(codigo);
    }


    public boolean loginUsuario(Usuario u, String rol) {
        List<Usuario> lstUsuarios=(List<Usuario>) usuarioCrudRepository.findAll();
        List<Usuario> lstPorRol = lstUsuarios.stream().filter(usu -> usu.getRolUsu().equals(rol)).toList();

        Usuario usuEnc = (Usuario) lstPorRol.stream().filter(usu -> u.getUsuario().equals(usu.getUsuario()) && passwordEncoder.matches(u.getContrasena(), usu.getContrasena())).findFirst().orElse(null);

        return usuEnc == null ? false : true;
    }

    public Usuario loginUsuarioObj(Usuario u, String rol) {
        List<Usuario> lstUsuarios=(List<Usuario>) usuarioCrudRepository.findAll();
        List<Usuario> lstPorRol = lstUsuarios.stream().filter(usu -> usu.getRolUsu().equals(rol)).toList();

        return (Usuario) lstPorRol.stream().filter(usu -> u.getUsuario().equals(usu.getUsuario()) && passwordEncoder.matches(u.getContrasena(), usu.getContrasena())).findFirst().orElse(null);
    }

    public Optional<Usuario> eliminarUsuario(String codigo) {

        Optional<Usuario> usuarioOptional = usuarioCrudRepository.findById(codigo);
        usuarioOptional.ifPresent(usuario -> {
            usuarioCrudRepository.delete(usuario);
        });
        return usuarioOptional;
    }
}
