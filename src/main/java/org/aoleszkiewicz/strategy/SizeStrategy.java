package org.aoleszkiewicz.strategy;

import org.aoleszkiewicz.annotation.Size;

import java.lang.reflect.Field;
import java.util.Optional;

public class SizeStrategy implements ValidationStrategy{
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (!field.isAnnotationPresent(Size.class)) {
            return Optional.empty();
        }

        Size annotation = field.getAnnotation(Size.class);

        if (value instanceof String strValue) {
            int length = strValue.length();
            int min = annotation.min();
            int max = annotation.max();

            if (length < min || length > max) {
                return Optional.of(
                        String.format("Length of '%s' must be between %d and %d, got (%d)",
                            field.getName(), min, max, length));
            }
        }

        return Optional.empty();
    }
}
