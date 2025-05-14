package org.aoleszkiewicz.factory;

import org.aoleszkiewicz.annotation.AcademicIndexNumber;
import org.aoleszkiewicz.annotation.Email;
import org.aoleszkiewicz.annotation.NotNull;
import org.aoleszkiewicz.annotation.Size;
import org.aoleszkiewicz.strategy.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ValidationStrategyFactory {
    private static final Map<Class<? extends Annotation>, ValidationStrategy> strategies = new HashMap<>();

    private ValidationStrategyFactory() {}

    static {
        strategies.put(NotNull.class, new NotNullStrategy());
        strategies.put(Size.class, new SizeStrategy());
        strategies.put(Email.class, new EmailStrategy());
        strategies.put(AcademicIndexNumber.class, new AcademicIndexNumberStrategy());
    }

    public static Optional<ValidationStrategy> getStrategy(Annotation annotation) {
        return Optional.ofNullable(strategies.get(annotation.annotationType()));
    }
}
