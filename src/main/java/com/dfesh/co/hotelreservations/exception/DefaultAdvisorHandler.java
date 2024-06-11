package com.dfesh.co.hotelreservations.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestControllerAdvice
public class DefaultAdvisorHandler {

    private static final String MESSAGE_LOG_ERROR = "{}: {}, uri {}, message {}";


    @ExceptionHandler({
            BadRequestException.class
    })
    public ResponseEntity<ApiError> handlerBadRequestException(HttpServletRequest req, Exception ex) {
        log.error(MESSAGE_LOG_ERROR, BAD_REQUEST.getReasonPhrase(), ex.getClass().getSimpleName(), req.getRequestURI(),
                ex.getMessage(), ex);
        return new ResponseEntity<>(new ApiError(CONFLICT.value(), ex.getClass().getSimpleName(), "Technical problems 1",
                ex.getMessage(), LocalDate.now()), BAD_REQUEST);
    }

}
