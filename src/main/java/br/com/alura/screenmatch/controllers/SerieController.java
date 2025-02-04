package br.com.alura.screenmatch.controllers;

import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public List<SerieDTO> findAll(){
        List<Serie> result = serieRepository.findAll();
        return result.stream().map(SerieDTO::new).collect(Collectors.toList());
    }



}
