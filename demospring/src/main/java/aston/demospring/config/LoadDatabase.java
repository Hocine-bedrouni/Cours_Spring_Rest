package aston.demospring.config;

import aston.demospring.entity.Guitare;
import aston.demospring.repository.GuitareRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(GuitareRepo guitareRepo) {

        return args -> {
            log.info("loading data" + guitareRepo.save(new Guitare("Gibson Explorer")));
            log.info("loading data" + guitareRepo.save(new Guitare("Gibson Decpuverte")));
            log.info("loading data" + guitareRepo.save(new Guitare("Gibson V1")));
            log.info("loading data" + guitareRepo.save(new Guitare("Gibson V2")));
            log.info("loading data" + guitareRepo.save(new Guitare("Gibson V3")));
        };

    }
}
