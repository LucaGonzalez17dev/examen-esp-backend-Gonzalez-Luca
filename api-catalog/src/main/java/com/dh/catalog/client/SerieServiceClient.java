package com.dh.catalog.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name= "api-serie" )
public interface SerieServiceClient {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieDto> getSerieByGenre(@PathVariable (value = "genre") String genre);

    @Getter
    @Setter
    class SerieDto{
        private String id;
        private String name;
        private String genre;
        private List<Season> seasons = new ArrayList<>();
    }
    @Getter
    @Setter
    class Season {
        private Integer seasonNumber;
        private List<Chapter> chapters = new ArrayList<>();
    }
    @Getter
    @Setter
    class Chapter {
        private String name;
        private Integer number;
        private String urlStream;
    }



}