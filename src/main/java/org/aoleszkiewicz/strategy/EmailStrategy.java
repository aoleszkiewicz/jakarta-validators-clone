package org.aoleszkiewicz.strategy;

import org.aoleszkiewicz.annotation.Email;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.regex.Pattern;

public class EmailStrategy implements ValidationStrategy {
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (!field.isAnnotationPresent(Email.class)) {
            return Optional.empty();
        }

        Email annotation = field.getAnnotation(Email.class);
        String regexPattern = annotation.regexPattern();
        String email = value.toString();

        boolean isValid = Pattern.compile(regexPattern).matcher(email).matches();

        if (!isValid) {
            return Optional.of("Provided email is not valid");
        }

        return Optional.empty();
    }
}
