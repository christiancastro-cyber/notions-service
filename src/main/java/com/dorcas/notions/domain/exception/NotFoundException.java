package com.dorcas.notions.domain.exception;

public class NotFoundException extends DorcasException {

    public NotFoundException(ErrorCode code, String message) {
        super(code, message);
    }
}