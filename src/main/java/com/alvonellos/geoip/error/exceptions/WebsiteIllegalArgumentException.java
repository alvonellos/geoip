package com.alvonellos.geoip.error.exceptions;

public class WebsiteIllegalArgumentException extends WebsiteAPIException {
    public WebsiteIllegalArgumentException(String message) {
        super(message);
    }

    public WebsiteIllegalArgumentException(String message, Exception cause) {
        super(message, cause);
    }
}
