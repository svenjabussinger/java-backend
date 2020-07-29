package com.example.javabackend.repository;

import com.example.javabackend.model.Baum;
import com.example.javabackend.model.Strasse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaumRepository extends CrudRepository<Baum, Long> {

    List<Baum> findByStrasse(Strasse strasse);

    List<Baum> findByStrasseId(Long strasseId);

    Optional<Baum> findByIdAndStrasseId(Long baumId, Long strasseId);
}
