package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EpisodioDTO {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;

    public EpisodioDTO(){}

    public EpisodioDTO(Integer numeroEpisodio, Integer temporada, String titulo) {
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
