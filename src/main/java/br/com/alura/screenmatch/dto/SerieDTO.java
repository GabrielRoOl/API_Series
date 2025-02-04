package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Serie;

import java.util.Optional;

public class SerieDTO {
    private Long id;
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private String escritor;
    private String atores;
    private String poster;
    private String sinopse;

    public SerieDTO(){}

    public SerieDTO(String atores, Double avaliacao, String escritor, Long id, String poster, String sinopse, String titulo, Integer totalTemporadas) {
        this.atores = atores;
        this.avaliacao = avaliacao;
        this.escritor = escritor;
        this.id = id;
        this.poster = poster;
        this.sinopse = sinopse;
        this.titulo = titulo;
        this.totalTemporadas = totalTemporadas;
    }

    public SerieDTO(Serie s) {
        this.atores = s.getAtores();
        this.avaliacao = s.getAvaliacao();
        this.escritor = s.getEscritor();
        this.id = s.getId();
        this.poster = s.getPoster();
        this.sinopse = s.getPoster();
        this.titulo = s.getTitulo();
        this.totalTemporadas = s.getTotalTemporadas();
    }

    public SerieDTO(Optional<Serie> result) {
        result.stream().map(SerieDTO::new);
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }
}
