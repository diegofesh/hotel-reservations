package com.dfesh.co.hotelreservations.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{

    private static final long serialVersionUID = -17133932145658813L;

    private final String description;

    private final Integer statusCode;


    /**
     * Generic Exception with message only.
     * @param description description
     */
    public ApiException(String description) {
        super(description);
        this.description = description;
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    /**
     * Generic Exception with message and cause only.
     * @param description description
     * @param cause       cause
     */
    public ApiException(String description, Throwable cause) {
        super(description, cause);
        this.description = description;
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    /**
     * Instantiates a new Api exception.
     * @param description the description
     * @param statusCode  the status code
     */
    public ApiException(String description, Integer statusCode) {
        super(description);
        this.description = description;
        this.statusCode = statusCode;
    }

    /**
     * Instantiates a new Api exception.
     * @param description the description
     * @param statusCode  the status code
     * @param cause       the cause
     */
    public ApiException(String description, Integer statusCode, Throwable cause) {
        super(description, cause);
        this.description = description;
        this.statusCode = statusCode;
    }


    @Override
    public String toString() {
        return "ApiException{" +
                "description='" + description + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
