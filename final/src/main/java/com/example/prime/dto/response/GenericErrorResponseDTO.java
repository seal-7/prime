package com.example.prime.dto.response;

public class GenericErrorResponseDTO {

    private final long timestamp = System.currentTimeMillis();
    private final String errorCode;
    private final String errorMessage;

    public GenericErrorResponseDTO(final String errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
