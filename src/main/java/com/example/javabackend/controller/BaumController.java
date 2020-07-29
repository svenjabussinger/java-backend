package com.example.javabackend.controller;

import com.example.javabackend.model.Baum;
import com.example.javabackend.model.Strasse;
import com.example.javabackend.repository.BaumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@Controller
public class BaumController {

    @Autowired
    BaumRepository baumRepository;


    @GetMapping(path="/baum")
    public @ResponseBody Iterable<Baum> getAll() {
        return baumRepository.findAll();
    }

    @GetMapping(path = "/baum/{id}")
    public @ResponseBody Optional<Baum> getById(@PathVariable Long id) {
        return baumRepository.findById(id);
    }

    @GetMapping(path="/strasse/{strasseId}/baum")
    public @ResponseBody
    Iterable<Baum> allByStreet(@PathVariable Long strasseId) {
        return baumRepository.findByStrasseId(strasseId);
    }

    @GetMapping(path="/strasse/{strasseId}/baum/{baumId}")
    public @ResponseBody
    Optional<Baum> getByIdAndStrasseId(@PathVariable Long strasseId, @PathVariable Long baumId) {
        return baumRepository.findByIdAndStrasseId(baumId, strasseId);
    }



}
