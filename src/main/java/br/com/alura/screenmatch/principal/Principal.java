package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.*;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2def0c3f";

    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository serieRepository;

    private List<Serie> series = new ArrayList<>();

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }


    public void exibeMenu() {

        var menu = """
                1 - Buscar séries
                2 - Buscar episódios
                3 - Listar séries buscadas
                4 - Buscar série por título
                5 - Buscar séries por ator e avaliação mínima
                6 - Top 5 séries com melhor avaliação
                7 - Buscar séries pela categoria
                8 - Filtrar séries
                
                0 - Sair
                """;
        var opcao = -1;

        while (opcao != 0) {
            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriePorCategoria();
                    break;
                case 8:
                    filtrarSeriesPorTemporadaEAvaliacao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSeriePorCategoria() {
        System.out.print("Deseja buscar séries de qual categoria/gênero?");
        var nomeGenero = sc.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        List<Serie> seriePorCategoria = serieRepository.findByGenero(categoria);
        System.out.println("Séries da categoria: " + nomeGenero);
        seriePorCategoria.forEach(System.out::println);
    }

    private void buscarTop5Series() {
        List<Serie> buscaTop = serieRepository.findTop5ByOrderByAvaliacaoDesc();
        if(buscaTop.isEmpty()){
            System.out.println("Nenhuma série encontrada para exibir o Top 5.");
        }else {
            System.out.println("Top 5 séries com melhor avaliação: ");
            buscaTop.forEach(s ->
                    System.out.println(s.getTitulo().toUpperCase() +
                            " avaliação: " + s.getAvaliacao()));
        }
        System.out.println();
    }

    private void buscarSeriePorAtor() {
        System.out.print("Nome para busca: ");
        var nomeAutor = sc.nextLine();
        if(nomeAutor.isEmpty()){
            System.out.println("O nome do autor não pode ser vazio.");
            return;
        }
        System.out.print("Avaliações a partir de qual valor: ");
        if(!sc.hasNextDouble()){
            System.out.println("Favor, insira um valor numérioc válido para avaliação.");
            sc.next();
            return;
        }
        var avaliacaoAtor = sc.nextDouble();

        List<Serie> seriesEncontradas = serieRepository.
                findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAutor, avaliacaoAtor);

        if(seriesEncontradas.isEmpty()){
            System.out.println("Nenhuma série com o ator " + nomeAutor + " e avaliação acima de " + avaliacaoAtor +
                    " foram encontradas.");
        }else{
            System.out.println("Series em que " + nomeAutor + " trabalhou: ");
            seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " Avaliação geral da série: "
                    + s.getAvaliacao()));
        }

        System.out.println();
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série pelo nome:");
        var nomeSerie = sc.nextLine();
        Optional<Serie> serieBuscada = serieRepository.findByTituloContainingIgnoreCase(nomeSerie);

        if(serieBuscada.isPresent()){
            System.out.println("Dados da série: " + serieBuscada.get());
        }else {
            System.out.println("Série não encontrada.");
        }
    }

    private void listarSeriesBuscadas() {
        series = serieRepository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        //dadosSeries.add(dados);
        serieRepository.save(serie);
        System.out.println(dados);
        System.out.println("Série salva com sucesso: " + serie.getTitulo().toUpperCase());
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = converte.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
//        DadosSerie dadosSerie = getDadosSerie();
        listarSeriesBuscadas();
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = sc.nextLine();

        Optional<Serie> serie = serieRepository.findByTituloContainingIgnoreCase(nomeSerie);


        if(serie.isPresent()){

            var serieEncontrada = serie.get();

            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo()
                        .replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodioList(episodios);
            serieRepository.save(serieEncontrada);

        } else{
            System.out.println("Série não econtrada.");
        }
    }

    private void filtrarSeriesPorTemporadaEAvaliacao(){
        System.out.print("Filtrar séries até quantas temporadas? ");
        var totalTemporadas = sc.nextInt();
        sc.nextLine();
        System.out.print("Com avaliação a partir de que valor? ");
        var avaliacao = sc.nextInt();
        sc.nextLine();

        List<Serie> filtroSeries = serieRepository.seriesPorTemporadaEAvaliacao(totalTemporadas,avaliacao);
//      List<Serie> filtroSeries = serieRepository.findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(totalTemporadas,avaliacao);
        System.out.println("*** Séries filtradas ***");
        filtroSeries.forEach(s -> System.out.println(s.getTitulo() + " - avaliação: " + s.getAvaliacao()));
    }
}
