package com.jobhun.ujian_bnsp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GLobalExceptionController {

    @ExceptionHandler({Exception.class})
    public String handleException(Exception e){
        return "fragments/error";
    }
}
