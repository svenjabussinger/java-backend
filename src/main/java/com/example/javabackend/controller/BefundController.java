package com.example.javabackend.controller;


import com.example.javabackend.model.Befund;
import com.example.javabackend.repository.BefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BefundController {

    @Autowired
    BefundRepository befundRepository;

    @GetMapping(path="/befund")
    public @ResponseBody
    Iterable<Befund> getAll() {
        return befundRepository.findAll();
    }

    @GetMapping(path = "/baum/{baumId}/befund")
    public @ResponseBody
    Iterable<Befund> getAllByBaumId (@PathVariable Long baumId) {
        return befundRepository.findByBaumId(baumId);
    }
}
