package com.k15t.pat.registration.exception.specific.job;


import com.k15t.pat.registration.exception.general.NoSuchResourceException;

/**
 *
 * @author parvizmakarti@gmail.com
 */
public class NoSuchJobException extends NoSuchResourceException {

    public NoSuchJobException(String message) {
        super(message);
    }

    public NoSuchJobException(String message, Throwable cause) {
        super(message, cause);
    }

}
