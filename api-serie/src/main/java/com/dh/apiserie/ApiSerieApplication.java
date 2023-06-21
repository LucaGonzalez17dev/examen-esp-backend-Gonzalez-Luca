package com.dh.apiserie;

import com.dh.apiserie.model.Chapter;
import com.dh.apiserie.model.Season;
import com.dh.apiserie.model.Serie;
import com.dh.apiserie.repository.SerieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories
public class ApiSerieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSerieApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(SerieRepository repository) {
		String baseUrl = "www.netflix.com/series";

		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}

			//Serie A terror
			List<Chapter> serieASeasonAChapters = List.of(
					new Chapter("Chapter A", 1, baseUrl + "/terror/1/season/1/chapter/1"),
					new Chapter("Chapter B", 2, baseUrl + "/terror/1/season/1/chapter/2")
			);

			List<Chapter> serieASeasonBChapters = List.of(
					new Chapter("Chapter A", 1, baseUrl + "/terror/1/season/2/chapter/1"),
					new Chapter("Chapter B", 2, baseUrl + "/terror/1/season/2/chapter/2")
			);

			List<Season> serieASeasons = List.of(
					new Season(1, serieASeasonAChapters),
					new Season(2, serieASeasonBChapters)
			);

			//Serie B comedia
			List<Chapter> serieBSeasonAChapters = List.of(
					new Chapter("Chapter A", 1, baseUrl + "/comedia/1/season/1/chapter/1"),
					new Chapter("Chapter B", 2, baseUrl + "/comedia/1/season/1/chapter/2")
			);

			List<Chapter> serieBSeasonBChapters = List.of(
					new Chapter("Chapter A", 1, baseUrl + "/comedia/1/season/2/chapter/1"),
					new Chapter("Chapter B", 2, baseUrl + "/comedia/1/season/2/chapter/2")
			);

			List<Season> serieBSeasons = List.of(
					new Season(1, serieBSeasonAChapters),
					new Season(2, serieBSeasonBChapters)
			);

			Serie serieA = new Serie( UUID.randomUUID().toString(),"Serie A", "terror", serieASeasons);
			Serie serieB = new Serie( UUID.randomUUID().toString(),"Serie B", "comedia", serieBSeasons);
			repository.save(serieA);
			repository.save(serieB);

		};
	}

}
