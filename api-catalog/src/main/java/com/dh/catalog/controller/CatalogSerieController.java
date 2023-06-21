package com.dh.catalog.controller;


import com.dh.catalog.client.SerieServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogSerieController {

    private final SerieServiceClient serieServiceClient;

    public CatalogSerieController(SerieServiceClient serieServiceClient) {
        this.serieServiceClient = serieServiceClient;
    }

    @GetMapping("/serie/{genre}")
    ResponseEntity<List<SerieServiceClient.SerieDto>> getSerieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(serieServiceClient.getSerieByGenre(genre));
    }

}