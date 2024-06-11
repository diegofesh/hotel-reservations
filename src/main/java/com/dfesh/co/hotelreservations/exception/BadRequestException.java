package com.dfesh.co.hotelreservations.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {

    private static int badRequestExceptionStatusCode = HttpStatus.BAD_REQUEST.value();

    /**
     * Instantiates a new BadRequest exception.
     * @param description the message
     */
    public BadRequestException(String description) {
        super(description, badRequestExceptionStatusCode);
    }

    /**
     * Instantiates a new BadRequest exception.
     * @param description the message
     * @param cause       the cause
     */
    public BadRequestException(String description, Throwable cause) {
        super(description, badRequestExceptionStatusCode, cause);
    }

}
