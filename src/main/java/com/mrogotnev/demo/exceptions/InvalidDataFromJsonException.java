package com.mrogotnev.demo.exceptions;

public class InvalidDataFromJsonException extends Exception {
    public InvalidDataFromJsonException() {
    }

    public InvalidDataFromJsonException(String message) {
        super(message);
    }

    public InvalidDataFromJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataFromJsonException(Throwable cause) {
        super(cause);
    }

    public InvalidDataFromJsonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
