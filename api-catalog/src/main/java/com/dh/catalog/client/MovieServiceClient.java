package com.dh.catalog.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "api-movie" )
public interface MovieServiceClient {

	@GetMapping("/api/v1/movies/{genre}")
	@CircuitBreaker(name = "movieService", fallbackMethod = "fallbackGetMovieByGenre")
	List<MovieDto> getMovieByGenre(@PathVariable (value = "genre") String genre);

	default List<SerieServiceClient.SerieDto> fallbackGetMovieByGenre(String genre, Throwable e) throws Exception {
		throw new Exception("En este momento no es posible retornar la lista de peliculas, intente mas tarde");
	}

	@Getter
	@Setter
	class MovieDto{
		private Long id;

		private String name;

		private String genre;

		private String urlStream;
	}



}
