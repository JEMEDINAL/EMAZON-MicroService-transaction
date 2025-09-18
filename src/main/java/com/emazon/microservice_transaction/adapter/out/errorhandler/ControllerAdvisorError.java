package com.emazon.microservice_transaction.adapter.out.errorhandler;

import com.emazon.microservice_transaction.domain.constant.SuppliesBusinessRules;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisorError {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            errorDetails.put(((FieldError)error).getField(),error.getDefaultMessage());
            errorDetails.put(STATUS, HttpStatus.BAD_REQUEST.toString());
            errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> response = new HashMap<>();
        Throwable cause = ex.getCause();
        if (cause != null && cause.getCause() instanceof DateTimeParseException dtpe)  {
            response.put(MESSAGE, SuppliesBusinessRules.INVALID_FORMAT_DATE);
            response.put(STATUS, HttpStatus.BAD_REQUEST.toString());
            response.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        } else {
            response.put(MESSAGE, "Error: " + ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
