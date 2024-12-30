package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=2def0c3f");

		/*
		 * System.out.println("\n" + json + "\n");
		 * json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		 */

		// System.out.println("\n" + json + "\n");

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println("\n" + dados + "\n");

		json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=2def0c3f");

		ConverteDados converterSerie = new ConverteDados();
		DadosEpisodios dadosEpisodios = converterSerie.obterDados(json, DadosEpisodios.class);

		System.out.println("\n" + dadosEpisodios + "\n");

        List<DadosTemporada> temporada = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++){
            json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=2def0c3f");
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporada.add(dadosTemporada);
        }
        temporada.forEach(System.out::println);
	}

}
