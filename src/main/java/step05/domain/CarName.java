package step05.domain;

import exception.OutOfBoundLength;
import validator.HasContentsValidator;

import java.util.Objects;

public class CarName {
    private final String name;
    private final MaxLength maxLength;

    private CarName(String name, MaxLength maxLength) {
        this.maxLength = maxLength;
        this.name = name;

        isBlank(name);
        isInBoundLength();
    }

    public static CarName of(String name) {
        return new CarName(name, MaxLength.of());
    }

    public static CarName of(String name, int maxLength) {
        return new CarName(name, MaxLength.of(maxLength));
    }

    private static void isBlank(String name) {
        HasContentsValidator.validate(name);
    }

    private void isInBoundLength() {
        if (maxLength.isOutOfBoundLength(name)) {
            throw new OutOfBoundLength();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name) &&
                Objects.equals(maxLength, carName.maxLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxLength);
    }
}
