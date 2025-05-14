package org.aoleszkiewicz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AcademicIndexNumber {
    int length() default 8;
    String message() default "Provided index number is invalid";
}
