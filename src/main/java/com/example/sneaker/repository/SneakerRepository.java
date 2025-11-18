package com.example.sneaker.repository;

import com.example.sneaker.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
}

