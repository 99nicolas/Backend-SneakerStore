package com.example.sneaker.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sneaker {

    @Id
    @GeneratedValue
    private Long id;

    private String marca;
    private String modelo;
    private Double talla; // compatibilidad opcional
    private String color;
    private Double precio;
    private Integer stock;

    // URL de la imagen
    private String image;

    // Nueva: lista de tallas disponibles
    @ElementCollection
    private List<Double> tallas = new ArrayList<>();

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Double getTalla() { return talla; }
    public void setTalla(Double talla) { this.talla = talla; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public List<Double> getTallas() { return tallas; }
    public void setTallas(List<Double> tallas) { this.tallas = tallas; }
    //listaparatallasnuevas
}