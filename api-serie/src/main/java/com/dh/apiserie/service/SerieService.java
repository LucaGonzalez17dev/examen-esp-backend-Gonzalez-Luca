package com.dh.apiserie.service;

import com.dh.apiserie.event.SerieGuardadaEvent;
import com.dh.apiserie.model.Serie;
import com.dh.apiserie.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repository;

    private final SerieGuardadaEvent serieGuardadaEvent;



    public SerieService(SerieRepository repository, SerieGuardadaEvent serieGuardadaEvent) {
        this.repository = repository;
        this.serieGuardadaEvent = serieGuardadaEvent;
    }



    public List<Serie> getSeriesBygGenre(String genre) {
        return repository.findAllByGenre(genre);
    }

    public Serie createSerie(Serie seriesDto) {
        serieGuardadaEvent.guardar(new SerieGuardadaEvent.SerieDto(seriesDto.getId(),seriesDto.getName(),seriesDto.getGenre()));
        return repository.save(seriesDto);
    }
}
