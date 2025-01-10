package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Modelo para representar os dados dos episódios extraídos da API OMDB.
 * Mapeia os campos relevantes do JSON retornado pela API para propriedades imutáveis.
 * Campos importantes incluem título, número do episódio, avaliação, data de lançamento, escritor e idioma.
 */
@JsonIgnoreProperties(ignoreUnknown = true) // ignora todos os parametros que não foram espeficicados no record
public record DadosEpisodios(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") Integer numero,
        /**
         * Avaliação do episódio no IMDb, extraída diretamente do campo "imdbRating" da API OMDB.
         * O valor está como String, mas pode ser convertido para Double se necessário.
         */
        @JsonAlias("imdbRating") String avaliacao,
        @JsonAlias("Released") String data,
        @JsonAlias("Writer") String escritor,
        @JsonAlias("Language") String lingua) {

}
