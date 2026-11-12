package com.dorcas.notions.domain.exception;

public class SupplierNotFoundException extends NotFoundException {
    public SupplierNotFoundException(Long id) {

        super(ErrorCode.SUPPLIER_NOT_FOUND, "Not supplier Found for that id: " + id);
    }
}
