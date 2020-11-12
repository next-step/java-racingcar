package step05.domain;

import exception.OutOfBoundLength;
import validator.HasContentsValidator;

public class CarName {
    private final String name;
    private final MaxLength maxLength;

    private CarName(String name, MaxLength maxLength) {
        this.maxLength = maxLength;
        this.name = name;

        isBlank(name);
        isInBoundLength();
    };

    public static CarName of (String name) {
        return new CarName(name, MaxLength.of());
    };

    public static CarName of (String name, int maxLength) {
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

}
