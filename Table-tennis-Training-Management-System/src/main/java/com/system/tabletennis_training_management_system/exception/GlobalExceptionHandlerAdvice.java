package com.system.tabletennis_training_management_system.exception;

import com.system.tabletennis_training_management_system.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class})
    public ResponseMessage<?> handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("统一异常:", e);
        return new ResponseMessage<>(500, "error", null);
    }
}
