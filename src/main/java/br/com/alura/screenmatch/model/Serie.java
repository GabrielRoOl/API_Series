package br.com.alura.screenmatch.model;

import jdk.jfr.Category;

import java.util.OptionalDouble;
/**
 * Representa uma série com informações detalhadas como título, número de temporadas,
 * avaliação, gênero, elenco, e outros dados provenientes da API OMDB.
 */
public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private String escritor;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;
    private CategoriaLinguagem lingua;

    public Serie(DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = parseAvaliacao(dadosSerie.avaliacao());
        //this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        //Categoria.fromString(dadosSerie.genero().split(",")[0].trim()); // Para pegar apenas o primeiro genero
        this.genero = parseGenerio(dadosSerie.genero());
        this.escritor = dadosSerie.escritor();
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = dadosSerie.sinopse();
        this.lingua = CategoriaLinguagem.fromString(dadosSerie.lingua());
    }

    private Categoria parseGenerio(String genero) {
        return Categoria.fromString(genero.split(",")[0].trim()); // Para pegar apenas o primeiro genero
    }

    public Double parseAvaliacao(String avaliacao){
        try{
            return Double.valueOf(avaliacao);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
