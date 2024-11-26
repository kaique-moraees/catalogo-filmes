package com.example.catalogofilmes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogofilmes.dto.FilmeDTO;
import com.example.catalogofilmes.model.Filme;
import com.example.catalogofilmes.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    // Listar todos os filmes
    public List<FilmeDTO> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        return filmes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar filme por ID
    public Optional<FilmeDTO> buscarFilmePorId(Long id) {
        return filmeRepository.findById(id).map(this::convertToDTO);
    }

    // Adicionar um novo filme
    public FilmeDTO adicionarFilme(FilmeDTO filmeDTO) {
        Filme filme = convertToEntity(filmeDTO);
        Filme filmeSalvo = filmeRepository.save(filme);
        return convertToDTO(filmeSalvo);
    }

    // Atualizar um filme existente
    public Optional<FilmeDTO> atualizarFilme(Long id, FilmeDTO filmeDTO) {
        Optional<Filme> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()) {
            Filme filme = filmeExistente.get();
            filme.setTitulo(filmeDTO.getTitulo());
            filme.setGenero(filmeDTO.getGenero());
            filme.setDuracao(filmeDTO.getDuracao());
            filme.setDescricao(filmeDTO.getDescricao());
            filme.setDataLancamento(FilmeDTO.parseDataLancamento(filmeDTO.getDataLancamento()));

            Filme filmeAtualizado = filmeRepository.save(filme);
            return Optional.of(convertToDTO(filmeAtualizado));
        }
        return Optional.empty();
    }

    // Deletar um filme
    public boolean removerFilme(Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método para converter Filme para FilmeDTO
    private FilmeDTO convertToDTO(Filme filme) {
        return new FilmeDTO(
                filme.getId(),
                filme.getTitulo(),
                filme.getGenero(),
                filme.getDuracao(),
                filme.getDescricao(),
                FilmeDTO.formatDataLancamento(filme.getDataLancamento()),
                filme.getImagem()
        );
    }

    // Método para converter FilmeDTO para Filme
    private Filme convertToEntity(FilmeDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setTitulo(filmeDTO.getTitulo());
        filme.setGenero(filmeDTO.getGenero());
        filme.setDuracao(filmeDTO.getDuracao());
        filme.setDescricao(filmeDTO.getDescricao());
        filme.setDataLancamento(FilmeDTO.parseDataLancamento(filmeDTO.getDataLancamento()));
        filme.setImagem(filmeDTO.getImagem());
        return filme;
    }
}
