package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<SerieDTO> findAll(){
        List<Serie> result = serieRepository.findAll();
        return result.stream().map(SerieDTO::new).collect(Collectors.toList());
    }

    public List<SerieDTO> findTop5Series(){
        List<Serie> result = serieRepository.findTop5ByOrderByAvaliacaoDesc();
        return result.stream().map(SerieDTO::new).collect(Collectors.toList());
    }
}
