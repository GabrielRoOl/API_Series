package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2def0c3f";


    public void exibeMenuI(){

//        System.out.print("Digite o nome da série para busca: ");
//
//        var nomeSerie = sc.nextLine();
//
//        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//
//        DadosSerie dados = converte.obterDados(json, DadosSerie.class);
//        System.out.println(dados + "\n");
//
//        List<DadosTemporada> temporada = new ArrayList<>();
//
//        for (int i = 1; i <= dados.totalTemporadas(); i++){
//            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
//            DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
//            temporada.add(dadosTemporada);
//        }
//        temporada.forEach(System.out::println);
//        System.out.println();
//
////        for(int i = 0; i < dados.totalTemporadas(); i++){
////            List<DadosEpisodios> episodiosTemporada = temporada.get(i).episodios();
////
////            System.out.println("Temporada " + (i + 1));
////            for(int j = 0; j < episodiosTemporada.size(); j++){
////                System.out.println(episodiosTemporada.get(j).titulo());
////            } System.out.println();
////        }
//
//        temporada.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
//
//        temporada.forEach(System.out::println);

        List<String> nomes = Arrays.asList("Gabriel", "Alamir", "Adriane", "Daniel");

        nomes.stream().sorted()
                .limit(2)
                .filter(n -> n.startsWith("A"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);


    }


}
