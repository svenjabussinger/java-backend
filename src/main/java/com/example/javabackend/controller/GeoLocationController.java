package com.example.javabackend.controller;

import com.example.javabackend.model.GeoLocation;
import com.example.javabackend.repository.GeoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeoLocationController {

    @Autowired
    GeoLocationRepository geoLocationRepository;

    @GetMapping(path="/geolocation")
    public @ResponseBody
    Iterable<GeoLocation> getAllGeoLocations() {
        return geoLocationRepository.findAll();
    }
}
