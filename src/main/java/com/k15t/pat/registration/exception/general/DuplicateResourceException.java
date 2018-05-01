package com.k15t.pat.registration.exception.general;


import com.k15t.pat.registration.exception.BusinessException;

/**
 * Created by Parviz on 29.04.2018.
 * Whenever there's a unique constraint on entity it handles the exceptions by wrapping DataIntegrityViolationException to this exception
 */
public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(String message) {
        super(message);
    }

    public DuplicateResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
