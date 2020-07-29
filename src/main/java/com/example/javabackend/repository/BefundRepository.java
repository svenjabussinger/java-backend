package com.example.javabackend.repository;

import com.example.javabackend.model.Baum;
import com.example.javabackend.model.Befund;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BefundRepository extends CrudRepository<Befund, Long> {

    List<Befund> findByBaumId(Long baumId);
}
