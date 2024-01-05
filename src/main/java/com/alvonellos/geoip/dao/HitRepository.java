package com.alvonellos.geoip.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HitRepository extends CrudRepository<Hit, UUID> {
    @Query("select count(*) from Hit")
    Long countAll();
}