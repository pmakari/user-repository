package com.k15t.pat.registration.exception.specific;


import com.k15t.pat.registration.exception.general.DuplicateResourceException;

/**
 *
 * @author parvizmakarti@gmail.com
 */
public class DuplicateUserException extends DuplicateResourceException {

    public DuplicateUserException(String message) {
        super(message);
    }

    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

}
