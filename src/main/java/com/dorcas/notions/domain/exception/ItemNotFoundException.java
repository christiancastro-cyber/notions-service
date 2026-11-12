package com.dorcas.notions.domain.exception;

public class ItemNotFoundException extends NotFoundException {

    public ItemNotFoundException(Long id) {
        super(ErrorCode.ITEM_NOT_FOUND, "Item not found with id " + id);
    }
}