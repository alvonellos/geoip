package com.alvonellos.geoip.service;


import com.alvonellos.geoip.dao.Hit;
import com.alvonellos.geoip.dao.HitRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log
@Service
@RequiredArgsConstructor
public class HitService {
    private final HitRepository hits;

    public void registerHit(HttpServletRequest request) {
        hits.save(Hit.builder()
              .id(UUID.randomUUID())
              .ip(request.getRemoteAddr())
              .url(request.getRequestURL().toString())
              .userAgent(request.getHeader("User-Agent"))
              .build()

        );
        log.info(String.format("Hit count: %d", hits.countAll()));
    }

    public Long getHitCount() {
        return hits.countAll();
    }
}
