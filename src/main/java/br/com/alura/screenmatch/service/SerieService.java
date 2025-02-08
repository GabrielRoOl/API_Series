package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<SerieDTO> findAll() {
        List<Serie> result = serieRepository.findAll();
        return result.stream().map(SerieDTO::new).collect(Collectors.toList());
    }

    public List<SerieDTO> findTop5Series() {
        List<Serie> result = serieRepository.findTop5ByOrderByAvaliacaoDesc();
        return result.stream().map(SerieDTO::new).collect(Collectors.toList());
    }

    public List<SerieDTO> findByLancamento() {
        List<Serie> resutl = serieRepository.findTop5ByOrderByEpisodioListDataLancamentoDesc();
        return resutl.stream().map(SerieDTO::new).collect(Collectors.toList());
    }

    public SerieDTO findById(Long id) {
        Optional<Serie> result = serieRepository.findById(id);
        return result.map(SerieDTO::new).orElse(null);
    }

    // Essa parte da aula, não foi necessara.

//    public List<SerieDTO> lancamentosMaisRecentes(){
//        List<Serie> result = serieRepository.lancamentosMaisRecentes();
//        return result.stream().map(SerieDTO::new).toList();
//    }

    public List<EpisodioDTO> getAllTemporadas(Long id){
        Optional<Serie> result = serieRepository.findById(id);
        if(result.isPresent()){
            Serie s = result.get();
            return s.getEpisodioList().stream().map(e ->
                    new EpisodioDTO(e.getNumeroEpisodio(), e.getTemporada(), e.getTitulo()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDTO> obterTemporadasPorNumero(Long id, Long numero) {
        return serieRepository.obterEpisodiosPorTemporada(id, numero)
                .stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }
}
