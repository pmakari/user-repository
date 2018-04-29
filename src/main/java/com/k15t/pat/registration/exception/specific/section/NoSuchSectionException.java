package com.k15t.pat.registration.exception.specific.section;


import com.k15t.pat.registration.exception.general.NoSuchResourceException;

/**
 *
 * @author parvizmakarti@gmail.com
 */
public class NoSuchSectionException extends NoSuchResourceException {

    public NoSuchSectionException(String message) {
        super(message);
    }

    public NoSuchSectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
