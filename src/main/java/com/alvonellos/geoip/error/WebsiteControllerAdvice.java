package com.alvonellos.geoip.error;

import com.alvonellos.geoip.error.exceptions.WebsiteIdNotFoundException;
import com.alvonellos.geoip.error.exceptions.WebsiteIllegalArgumentException;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import lombok.extern.java.Log;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;
import java.util.Optional;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice(annotations = RestController.class)
@Order(HIGHEST_PRECEDENCE)
@RequestMapping(produces = "application/api.error+json")
@Log
public class WebsiteControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WebsiteIdNotFoundException.class)
    public ResponseEntity<WebsiteAPIError> notFoundException(final WebsiteIdNotFoundException e) {
        log.info("InterviewKeyNotFoundException: " + e.getMessage() + " " +  e.getId());
        return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<WebsiteAPIError> argumentNotValid(final WebsiteIllegalArgumentException e) {
        log.info("IllegalArgumentException handler executed");
        return error(e, HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WebsiteAPIError> internalServerError(final Exception e) {
        log.severe("Internal server error: " + e.getMessage() + " " + e.getStackTrace());
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<WebsiteAPIError> fileNotFound(final FileNotFoundException e) {
        log.info("Page not found: " + e.getMessage() + " " + e.getStackTrace());
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<WebsiteAPIError> ipNotFound(final AddressNotFoundException e) {
        log.info("IP Not Found: " + e.getMessage() + " " + e.getStackTrace());
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<WebsiteAPIError> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new WebsiteAPIError(logRef, message, exception), httpStatus);
    }

}