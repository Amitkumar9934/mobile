package com.webapp.mobile.exception;

import com.webapp.mobile.dto.ErrorClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RNFException.class)
    public ResponseEntity<ErrorClass> errormessage(RNFException e, WebRequest webRequest){
        ErrorClass errorClass = new ErrorClass(e.getMessage(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
