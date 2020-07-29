package com.example.javabackend.repository;

import com.example.javabackend.model.Stadt;
import org.springframework.data.repository.CrudRepository;

public interface StadtRepository extends CrudRepository<Stadt, Long> {
}
