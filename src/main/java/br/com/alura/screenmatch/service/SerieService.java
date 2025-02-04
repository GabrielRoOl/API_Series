package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.SerieDTO;
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
}
