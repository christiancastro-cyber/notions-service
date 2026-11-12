package com.dorcas.notions.domain.exception;

import lombok.Getter;

@Getter
public class DorcasException extends RuntimeException {
    private final ErrorCode code;
    public DorcasException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}
