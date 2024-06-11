package com.dfesh.co.hotelreservations.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private Integer statusCode;
    private String error;
    private String trace;
    private String message;
    private LocalDate timeStamp;

}
