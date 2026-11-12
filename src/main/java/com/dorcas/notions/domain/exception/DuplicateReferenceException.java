package com.dorcas.notions.domain.exception;

public class DuplicateReferenceException extends ConflictException {
    public DuplicateReferenceException(String reference) {

        super(ErrorCode.DUPLICATE_REFERENCE, "Duplicate " + reference);
    }
}
