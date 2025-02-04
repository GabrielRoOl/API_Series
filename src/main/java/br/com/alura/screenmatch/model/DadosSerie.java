package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Modelo para representar os dados das séries extraídos da API OMDB.
 * Mapeia os campos relevantes do JSON retornado pela API para propriedades imutáveis.
 * Inclui informações como título, número de temporadas, avaliação, elenco, gênero, sinopse e idioma.
 */
@JsonIgnoreProperties(ignoreUnknown = true) // ignora todos os parametros que não foram espeficicados no record
public record DadosSerie(
                @JsonAlias("Title") String titulo,
                @JsonAlias("totalSeasons") Integer totalTemporadas,
                @JsonAlias("imdbRating") String avaliacao,
                @JsonAlias("Writer") String escritor,
                @JsonAlias("Genre") String genero,
                @JsonAlias("Actors") String atores,
                @JsonAlias("Poster") String poster,
                @JsonAlias("Plot") String sinopse,
                @JsonAlias("Language") String lingua) {
}
