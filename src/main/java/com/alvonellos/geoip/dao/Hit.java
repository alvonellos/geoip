package com.alvonellos.geoip.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name = "hit")
@AllArgsConstructor
@NoArgsConstructor
public class Hit {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "url")
    private String url;

    @Column(name = "userAgent")
    private String userAgent;

}