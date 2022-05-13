package com.ers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message
     */
    public RecordNotFoundException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param t
     */
    public RecordNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
