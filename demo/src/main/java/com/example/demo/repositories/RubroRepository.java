package com.example.demo.repositories;

import com.example.demo.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro, Long> {
}