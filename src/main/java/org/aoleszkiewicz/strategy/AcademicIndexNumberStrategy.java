package org.aoleszkiewicz.strategy;

import org.aoleszkiewicz.annotation.AcademicIndexNumber;

import java.lang.reflect.Field;
import java.util.Optional;

public class AcademicIndexNumberStrategy implements ValidationStrategy {
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (!field.isAnnotationPresent(AcademicIndexNumber.class)) {
            return Optional.empty();
        }

        AcademicIndexNumber annotation = field.getAnnotation(AcademicIndexNumber.class);

        if (value instanceof String strValue) {
            int strLength = strValue.length();
            int annotationLength = annotation.length();

            if (strLength != annotationLength) {
                return Optional.of(
                        String.format("Index number requires %d characters length",
                                annotationLength)
                );
            }
        }

        return Optional.empty();
    }
}
