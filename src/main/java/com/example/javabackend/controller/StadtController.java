package com.example.javabackend.controller;

import com.example.javabackend.model.Stadt;
import com.example.javabackend.repository.StadtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class StadtController {

    @Autowired
    StadtRepository stadtRepository;

    @GetMapping(path="/stadt")
    public @ResponseBody
    Iterable<Stadt> all() {
        return stadtRepository.findAll();
    }

    @GetMapping(path = "/stadt/{id}")
    public @ResponseBody
    Optional<Stadt> getById(@PathVariable Long id) {
        return stadtRepository.findById(id);
    }
}
