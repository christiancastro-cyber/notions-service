package com.dorcas.notions.domain.exception;

public class TagNotFoundException extends NotFoundException {
    public TagNotFoundException(Long id) {

        super(ErrorCode.TAG_NOT_FOUND, id + " not found");
    }
}
