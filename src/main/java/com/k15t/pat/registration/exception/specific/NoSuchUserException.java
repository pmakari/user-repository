package com.k15t.pat.registration.exception.specific;


import com.k15t.pat.registration.exception.general.NoSuchResourceException;

/**
 *
 * @author parvizmakarti@gmail.com
 */
public class NoSuchUserException extends NoSuchResourceException {

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause);
    }

}
