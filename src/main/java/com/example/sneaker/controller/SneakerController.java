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

    // Guardar (crear o actualizar)
    @PostMapping
    public Sneaker guardar(@RequestBody Sneaker sneaker) {
        return repo.save(sneaker);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // Actualizar solo el stock
    @PatchMapping("/{id}/stock")
    public Sneaker actualizarStock(@PathVariable Long id, @RequestParam Integer cantidad) {
        Sneaker sneaker = repo.findById(id).orElseThrow();
        sneaker.setStock(cantidad);
        return repo.save(sneaker);
    }
}

