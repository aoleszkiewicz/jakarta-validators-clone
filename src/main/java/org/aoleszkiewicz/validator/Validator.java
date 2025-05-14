package org.aoleszkiewicz.validator;

import org.aoleszkiewicz.exception.ValidationException;
import org.aoleszkiewicz.factory.ValidationStrategyFactory;
import org.aoleszkiewicz.strategy.ValidationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Validator {
    private Validator() {}

    public static void validate(Object object) throws ValidationException{
        final List<String> errors = new ArrayList<>();
        final Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            // Enable private attributes
            field.setAccessible(true);

            try {
                Object value = field.get(object);

                /*
                 * Get all annotations from specific field
                 *
                 * @NotNull
                 * @Email
                 * String email
                 *
                 * Retrieves @NotNull and @Email annotations
                 */
                for (Annotation annotation : field.getAnnotations()) {
                    Optional<ValidationStrategy> validationStrategy = ValidationStrategyFactory.getStrategy(annotation);

                    if (validationStrategy.isPresent()) {
                        Optional<String> error = validationStrategy.get().validate(field, value);

                        error.ifPresent(errors::add);
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add(String.format("Error while accessing field '%s'", field.getName()));
            }
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(
                    String.join("\n", errors)
            );
        }
    }
}
