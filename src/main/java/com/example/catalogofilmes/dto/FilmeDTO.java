package com.example.catalogofilmes.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilmeDTO {
    private Long id;
    private String titulo;
    private String genero;
    private int duracao;
    private String descricao;
    private String dataLancamento;
    private String imagem;

    // Construtores, Getters e Setters
    public FilmeDTO(Long id, String titulo, String genero, int duracao, String descricao, String dataLancamento, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.imagem = imagem;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    // Método para formatar a data de lançamento (LocalDate)
    public static String formatDataLancamento(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return data.format(formatter);
    }

    // Método para converter String para LocalDate
    public static LocalDate parseDataLancamento(String dataLancamento) {
        // Corrigido para o formato "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dataLancamento, formatter);
    }
}
