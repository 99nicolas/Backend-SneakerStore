package com.example.sneaker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sneaker {

    @Id
    @GeneratedValue
    private Long id;

    private String marca;
    private String modelo;
    private Double talla;
    private String color;
    private Double precio;
    private Integer stock;

    // Nueva propiedad para URL de imagen
    private String image;

    // id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // marca
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    // modelo
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    // talla
    public Double getTalla() { return talla; }
    public void setTalla(Double talla) { this.talla = talla; }

    // color
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // precio
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    // stock
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    // image (URL)
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}