package com.k15t.pat.registration.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A marker annotation to be used by BindingResultAspect to make the aspect
 * limited.
 *
 * Created by Parviz on 28.04.2018.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckBindingResult {

}
