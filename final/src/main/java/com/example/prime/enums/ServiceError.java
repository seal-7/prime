package com.example.prime.enums;

import org.springframework.http.HttpStatus;

public enum ServiceError {
    NOT_A_PRIME_NUMBER("ERR_001", "Given number is not a prime number.", HttpStatus.BAD_REQUEST),
    UNHANDLED_ERROR("ERR_002", "Unhandled error occured", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    ServiceError(final String errorCode, final String errorMessage, final HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
