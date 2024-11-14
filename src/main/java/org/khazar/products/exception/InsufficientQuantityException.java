package org.khazar.products.exception;

public class InsufficientQuantityException extends RuntimeException {

    public InsufficientQuantityException(String message) {
        super(message);
    }
}
