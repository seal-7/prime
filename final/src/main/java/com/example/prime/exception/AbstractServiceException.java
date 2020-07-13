package com.example.prime.exception;

import com.example.prime.enums.ServiceError;

public class AbstractServiceException extends Exception {
    protected ServiceError serviceError;

    public AbstractServiceException(final ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }
}
