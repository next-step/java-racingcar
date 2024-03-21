package racingcar.domain.car;

import static racingcar.config.RacingCarException.CAR_NAME_EXCEED_MAXIMUM_LENGTH;
import static racingcar.config.RacingCarException.CAR_NAME_NOT_MATCHES_PATTERN;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    public static final int NAME_MAXIMUM_LENGTH = 5;
    private static final Pattern namePattern = Pattern.compile("^[a-z0-9]+$");

    private final String value;

    Name(final String value) {
        this.value = value;
    }

    static Name from(final String value) {
        final String trimmedValue = value.trim();

        validateNameMatchesPattern(trimmedValue);
        validateNameNotExceedMaximumLength(trimmedValue);

        return new Name(trimmedValue);
    }

    private static void validateNameMatchesPattern(final String value) {
        if (notMatchesPattern(value)) {
            throw new IllegalArgumentException(CAR_NAME_NOT_MATCHES_PATTERN.message(value));
        }
    }

    private static boolean notMatchesPattern(final String value) {
        return !namePattern.matcher(value)
                .matches();
    }

    private static void validateNameNotExceedMaximumLength(final String value) {
        if (exceedMaximumLength(value)) {
            throw new IllegalArgumentException(CAR_NAME_EXCEED_MAXIMUM_LENGTH.message(value));
        }
    }

    private static boolean exceedMaximumLength(final String value) {
        return value.length() > NAME_MAXIMUM_LENGTH;
    }

    Name copyOf() {
        return new Name(this.value);
    }

    @Override
    public boolean equals(final Object otherName) {
        if (this == otherName) {
            return true;
        }

        if (otherName == null || getClass() != otherName.getClass()) {
            return false;
        }

        return this.value.equals(((Name)otherName).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
