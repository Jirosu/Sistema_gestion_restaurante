package com.rinconDelTaco.rincoTacosistema.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rinconDelTaco.rincoTacosistema.persitence.UsuarioRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Producto;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private HttpSession session;


    @GetMapping("/listar")
    public List<Usuario> listar(){
        return repo.listarUsuarios();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> registrar(@RequestParam("data") String data) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();
        Usuario usu = new ObjectMapper().readValue(data, Usuario.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String usuJson = objectMapper.writeValueAsString(usu);
        System.out.println(usuJson);

        if (usu == null) {
            response.put("valor", false);
            response.put("msg", "Error al ingresar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        repo.guardarUsuario(usu);
        response.put("valor", true);
        response.put("msg", "El usuario " + usu.getNomUsu() + " fue editado exitosamente!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam("data") String data) throws JsonProcessingException{
        Map<String, Object> response = new HashMap<>();
        Usuario usu = new ObjectMapper().readValue(data, Usuario.class);

        Usuario user = repo.loginUsuarioObj(usu, usu.getRolUsu());
        if(user == null){
            response.put("valor", false);
            response.put("msg", "Credenciales Incorrectas");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        session.setAttribute("usuario", user);
        response.put("valor", true);
        response.put("msg", "Bienvenido " + usu.getNomUsu() + "!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/cerrarsesion")
    public ResponseEntity<Void> cerrarSesion() {
        session.invalidate();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<Map<String, Object>> actualizar(@RequestParam("data") String data) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();
        Usuario usu = new ObjectMapper().readValue(data, Usuario.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String usuJson = objectMapper.writeValueAsString(usu);
        System.out.println(usuJson);

        if (usu == null) {
            response.put("valor", false);
            response.put("msg", "Error al ingresar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        repo.guardarUsuario(usu);
        response.put("valor", true);
        response.put("msg", "El usuario " + usu.getNomUsu() + " fue editado exitosamente!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){

        Optional<Usuario> usuarioOptional = repo.eliminarUsuario(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
