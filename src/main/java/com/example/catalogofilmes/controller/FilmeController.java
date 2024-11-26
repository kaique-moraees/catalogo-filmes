package com.example.catalogofilmes.controller;

import com.example.catalogofilmes.dto.FilmeDTO;
import com.example.catalogofilmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    // Listar todos os filmes
    @GetMapping
    public ResponseEntity<List<FilmeDTO>> listarFilmes() {
        List<FilmeDTO> filmes = filmeService.listarFilmes();
        return ResponseEntity.ok(filmes);
    }

    // Buscar filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> buscarFilmePorId(@PathVariable Long id) {
        Optional<FilmeDTO> filme = filmeService.buscarFilmePorId(id);
        return filme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adicionar um novo filme
    @PostMapping
    public ResponseEntity<FilmeDTO> adicionarFilme(@RequestBody FilmeDTO filmeDTO) {
        FilmeDTO filmeSalvo = filmeService.adicionarFilme(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }

    // Atualizar um filme existente
    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        Optional<FilmeDTO> filmeAtualizado = filmeService.atualizarFilme(id, filmeDTO);
        return filmeAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar um filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFilme(@PathVariable Long id) {
        boolean removido = filmeService.removerFilme(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
