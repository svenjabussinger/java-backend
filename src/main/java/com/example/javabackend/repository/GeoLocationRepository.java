package com.example.javabackend.repository;

import com.example.javabackend.model.GeoLocation;
import org.springframework.data.repository.CrudRepository;

public interface GeoLocationRepository extends CrudRepository<GeoLocation, Long> {
}
