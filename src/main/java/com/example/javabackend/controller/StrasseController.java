package com.example.javabackend.controller;

import com.example.javabackend.model.Strasse;
import com.example.javabackend.repository.StrasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StrasseController {

    @Autowired
    StrasseRepository strasseRepository;

    @GetMapping(path="/strasse")
    public @ResponseBody
    Iterable<Strasse> getAllStrasse() {
        return strasseRepository.findAll();
    }
}
