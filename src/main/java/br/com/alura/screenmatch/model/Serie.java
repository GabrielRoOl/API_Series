package br.com.alura.screenmatch.model;

import jakarta.persistence.*;

/**
 * Representa uma série com informações detalhadas como título, número de temporadas,
 * avaliação, gênero, elenco, e outros dados provenientes da API OMDB.
 */

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", unique = true, nullable = false)
    private String titulo;
    @Column(name = "numero_temporadas")
    private Integer totalTemporadas;
    private Double avaliacao;
    private String escritor;
    private String atores;
    private String poster;
    private String sinopse;

    @Enumerated(EnumType.STRING)
    private Categoria genero;
    @Column(name = "linguagem")
    @Enumerated(EnumType.STRING)
    private CategoriaLinguagem lingua;

    public Serie(){
    }

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
        //this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public CategoriaLinguagem getLingua() {
        return lingua;
    }

    public void setLingua(CategoriaLinguagem lingua) {
        this.lingua = lingua;
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

    @Override
    public String toString() {
        return  "genero=" + genero +
                ", atores='" + atores + '\'' +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", escritor='" + escritor + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", lingua=" + lingua;
    }
}
