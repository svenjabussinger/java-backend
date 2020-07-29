package com.example.javabackend;

import com.example.javabackend.model.*;
import com.example.javabackend.repository.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(JavaBackendApplication.class);

    Faker faker = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendApplication.class, args);
    }


    @Bean
    public CommandLineRunner dummy(StadtRepository stadtRepository, SpeziesRepository speziesRepository,
                                   StrasseRepository strasseRepository, BaumRepository baumRepository,
                                   GeoLocationRepository geoLocationRepository, BefundRepository befundRepository) {
        return (args) -> {

            if (stadtRepository.count() < 10) {
                log.info("Creating Dummy Data");

                List<Stadt> stadte = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    stadte.add(new Stadt(faker.address().zipCode(), faker.address().cityName()));
                }
                stadtRepository.saveAll(stadte);
                log.info("Created Stadt Dummy Data");

                List<Spezies> spezies = new ArrayList<>();

                for (int i = 0; i < 250; i++) {
                    spezies.add(new Spezies(faker.name().fullName(), faker.name().firstName()));
                }
                speziesRepository.saveAll(spezies);
                log.info("Created Spezies Dummy Data");


                for (Stadt stadt:stadtRepository.findAll()) {

                    List<Strasse> strassen = new ArrayList<>();
                    int rand = (int)(Math.random() * (200 - 10)) + 10;

                    for (int i = 0; i < rand; i++) {
                        strassen.add(new Strasse(faker.address().streetName(), faker.address().stateAbbr(), stadt));
                    }
                    strasseRepository.saveAll(strassen);
                    log.info("Created Strassen Dummy Data");
                }

                for(Strasse strasse: strasseRepository.findAll()) {
                    List<GeoLocation> geoLocations = new ArrayList<>();
                    List<Baum> baums = new ArrayList<>();

                    int rand = (int)(Math.random() * 800);

                    for (int i = 0; i < rand; i++) {
                        GeoLocation geoLocation = new GeoLocation(faker.number().randomDouble(6, -100, 100), faker.number().randomDouble(6, -100, 100));
                        geoLocations.add(geoLocation);

                        baums.add(new Baum(faker.number().randomNumber(), faker.date().birthday(), strasse, spezies.get(0), geoLocation));
                    }
                    geoLocationRepository.saveAll(geoLocations);
                    log.info("Created Geo Location Dummy Data");
                    baumRepository.saveAll(baums);
                    log.info("Created Baum Dummy Data");

                }

                for (Baum baum: baumRepository.findAll()) {
                    List<Befund> befunde = new ArrayList<>();
                    int rand = (int)(Math.random() * 10);

                    for (int i = 0; i < rand; i++) {
                        befunde.add(new Befund(faker.date().birthday(), faker.lorem().sentence(), baum));
                    }

                    befundRepository.saveAll(befunde);
                    log.info("Created Befund Dummy Data");
                }


            } else {
                log.info("Dummy Data already existing");
            }
        };
    }


}
