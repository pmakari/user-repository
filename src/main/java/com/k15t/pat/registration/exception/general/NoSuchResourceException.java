package com.k15t.pat.registration.exception.general;


import com.k15t.pat.registration.exception.BusinessException;

/**
 * Created by Parviz on 29.04.2018.
 */
public class NoSuchResourceException extends BusinessException {

    public NoSuchResourceException(String message) {
        super(message);
    }

    public NoSuchResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
