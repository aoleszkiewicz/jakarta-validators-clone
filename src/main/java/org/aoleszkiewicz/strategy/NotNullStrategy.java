package org.aoleszkiewicz.strategy;

import org.aoleszkiewicz.annotation.NotNull;

import java.lang.reflect.Field;
import java.util.Optional;

public class NotNullStrategy implements ValidationStrategy {
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            String message = String.format("Field '%s' %s", field.getName(), annotation.message());
            return Optional.of(message);
        }

        return Optional.empty();
    }
}
