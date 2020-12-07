package racing.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String value;

    private CarName(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static CarName of(final String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        return new CarName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        final CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
