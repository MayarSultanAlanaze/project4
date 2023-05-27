package com.example.demo.Advise;

import com.example.demo.ApiException.AipException;
import com.example.demo.ApiResponse.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advise {
    @ExceptionHandler(value =AipException.class)
    public ResponseEntity <ApiResponse> AipException(AipException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));

    }

}
