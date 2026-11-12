package com.dorcas.notions.domain.exception;

public class ConflictException extends DorcasException {

    public ConflictException(ErrorCode code, String message) {
        super(code, message);
    }
}