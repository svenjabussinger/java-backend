package com.example.javabackend.controller;


import com.example.javabackend.model.Spezies;
import com.example.javabackend.repository.SpeziesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SpeziesController {

    @Autowired
    SpeziesRepository speziesRepository;

    @GetMapping(path="/spezies")
    public @ResponseBody
    Iterable<Spezies> getAllSpezies() {
        return speziesRepository.findAll();
    }

    @GetMapping(path = "/baum/{baumId}/spezies")
    public @ResponseBody
    Optional<Spezies> getByBaumId (@PathVariable Long baumId) {
        return speziesRepository.findByBaumId(baumId);
    }
}
