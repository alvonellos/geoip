package com.alvonellos.geoip.error.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = true)
public class WebsiteIdNotFoundException extends WebsiteAPIException {
    private final UUID id;

    public WebsiteIdNotFoundException(final UUID id) {
        super("Entity with id " + id + " not found");
        this.id = id;
    }
}
