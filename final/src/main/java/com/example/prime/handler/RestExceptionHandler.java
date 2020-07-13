package com.example.prime.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.prime.dto.response.GenericErrorResponseDTO;
import com.example.prime.enums.ServiceError;
import com.example.prime.exception.AbstractServiceException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbstractServiceException.class)
    protected ResponseEntity<GenericErrorResponseDTO> handleCustomExceptions(AbstractServiceException e) {

        String errorCode = e.getServiceError().getErrorCode();
        String errorMessage = e.getServiceError().getErrorMessage();
        HttpStatus httpStatus = e.getServiceError().getHttpStatus();

        GenericErrorResponseDTO errorResponseDTO = new GenericErrorResponseDTO(errorCode, errorMessage);
        return new ResponseEntity<>(errorResponseDTO, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> defaultExceptionHandler(Exception e) {
        ServiceError serviceError = ServiceError.UNHANDLED_ERROR;
        GenericErrorResponseDTO errorResponseDTO = new GenericErrorResponseDTO(serviceError.getErrorCode(), serviceError.getErrorMessage());
        return new ResponseEntity<>(errorResponseDTO, serviceError.getHttpStatus());
    }

}
