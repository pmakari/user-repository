package com.k15t.pat.registration.exception.specific.section;


import com.k15t.pat.registration.exception.general.DuplicateResourceException;

/**
 *
 * @author parvizmakarti@gmail.com
 */
public class DuplicateSectionException extends DuplicateResourceException {

    public DuplicateSectionException(String message) {
        super(message);
    }

    public DuplicateSectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
