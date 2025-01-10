package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
/**
 * Modelo para representar os dados de uma temporada extraídos da API OMDB.
 * Contém o número da temporada e uma lista de episódios associados.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(
        @JsonAlias("Season") Integer numero,
        @JsonAlias("Episodes") List<DadosEpisodios> episodios) {
}
