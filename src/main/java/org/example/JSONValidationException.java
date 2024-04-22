package org.example;

public class JSONValidationException extends RuntimeException {
    public JSONValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JSONValidationException(String message) {
        super(message);
    }
}
