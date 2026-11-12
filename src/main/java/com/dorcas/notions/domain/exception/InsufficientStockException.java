package com.dorcas.notions.domain.exception;

public class InsufficientStockException extends ConflictException {

    public InsufficientStockException(String reference, int requested, int available) {
        super(ErrorCode.INSUFFICIENT_STOCK,
                "Not enough " + reference + ": requested " + requested + " units, only " + available + " left");
    }
}