package com.rinconDelTaco.rincoTacosistema.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rinconDelTaco.rincoTacosistema.persitence.ProductoRepository;
import com.rinconDelTaco.rincoTacosistema.persitence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoRepository repo;

    @GetMapping("/listar")
    public List<Producto> listar(){
        return repo.listarProductos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Map<String, Object>> guardar(@RequestParam("image") MultipartFile image, @RequestParam("data") String data) throws JsonProcessingException {
        Producto prod = new ObjectMapper().readValue(data, Producto.class);
        boolean _resultado = false;
        boolean imgGuardada = false;

        if (prod != null){
            ResponseEntity.status(HttpStatus.CREATED).body(repo.grabarProducto(prod));

            ObjectMapper objectMapper = new ObjectMapper();
            String prodJson = objectMapper.writeValueAsString(prod);
            System.out.println(prodJson);

            _resultado = true;
        }

        if (image != null && !image.isEmpty()) {
            String imagePath = "src/main/resources/" + prod.getRutaImg();
            System.out.println(imagePath);
            try (OutputStream stream = new FileOutputStream(imagePath)) {
                stream.write(image.getBytes());
                imgGuardada = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String, Object> response = new HashMap<>();
        if (_resultado == false || imgGuardada == false) {
            response.put("valor", false);
            response.put("msg", "Error al ingresar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("valor", true);
        response.put("msg", prod.getNomProd() + " fue agregado exitosamente!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Map<String, Object>> actualizar(@RequestParam("data") String data) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();

        Producto prod = new ObjectMapper().readValue(data, Producto.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String prodJson = objectMapper.writeValueAsString(prod);
        System.out.println(prodJson);

        if (prod == null) {
            response.put("valor", false);
            response.put("msg", "Error al ingresar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        repo.actualizarProducto(prod);
        response.put("valor", true);
        response.put("msg", prod.getNomProd() + " fue editado exitosamente!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){

        Optional<Producto> productoOptional = repo.eliminarProducto(id);
        if(productoOptional.isPresent()){
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
