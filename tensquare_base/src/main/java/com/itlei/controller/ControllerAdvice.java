package com.itlei.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
