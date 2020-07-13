package com.example.prime.exception;

import com.example.prime.enums.ServiceError;

public class NotPrimeException extends AbstractServiceException {

    public NotPrimeException(ServiceError serviceError) {
        super(serviceError);
    }
}
