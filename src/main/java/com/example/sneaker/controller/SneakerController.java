package com.example.sneaker.controller;

import com.example.sneaker.model.Sneaker;
import com.example.sneaker.repository.SneakerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sneakers")
@CrossOrigin("*")
public class SneakerController {

    private final SneakerRepository repo;

    public SneakerController(SneakerRepository repo) {
        this.repo = repo;
    }

    // Listar todas las zapatillas
    @GetMapping
    public List<Sneaker> listar() {
        return repo.findAll();
    }

    // Obtener una zapatilla por id
    @GetMapping("/{id}")
    public Sneaker obtenerPorId(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Guardar (crear)
    @PostMapping
    public Sneaker crear(@RequestBody Sneaker sneaker) {
        return repo.save(sneaker);
    }

    // Actualizar (reemplazar) una zapatilla por id
    @PutMapping("/{id}")
    public Sneaker actualizar(@PathVariable Long id, @RequestBody Sneaker data) {
        Sneaker existing = repo.findById(id).orElseThrow();
        existing.setMarca(data.getMarca());
        existing.setModelo(data.getModelo());
        existing.setTalla(data.getTalla());
        existing.setColor(data.getColor());
        existing.setPrecio(data.getPrecio());
        existing.setStock(data.getStock());
        existing.setImage(data.getImage()); // guardar URL de imagen
        return repo.save(existing);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // Actualizar solo el stock (opcional)
    @PatchMapping("/{id}/stock")
    public Sneaker actualizarStock(@PathVariable Long id, @RequestParam Integer cantidad) {
        Sneaker sneaker = repo.findById(id).orElseThrow();
        sneaker.setStock(cantidad);
        return repo.save(sneaker);
    }
}