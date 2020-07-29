package com.example.javabackend.repository;

import com.example.javabackend.model.Spezies;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpeziesRepository extends CrudRepository<Spezies, Long> {

    Optional<Spezies> findByBaumId(Long baumId);
}
