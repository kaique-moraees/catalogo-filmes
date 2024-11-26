package com.example.catalogofilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogofilmes.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
