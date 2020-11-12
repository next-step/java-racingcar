package step05.domain;

import exception.OutOfBoundCarName;
import validator.HasContentsValidator;

public class CarName {
    private final String name;
    private final int maxLength;
    private static final int defaultMaxLength = 5;

    private CarName(String name, int maxLength) {
        isBlank(name);
        isInBoundLength(name, maxLength);
        this.name = name;
        this.maxLength = maxLength;
    };

    public static CarName of (String name) {
        return new CarName(name, defaultMaxLength);
    };

    public static CarName of(String name, int maxLength) {
        return new CarName(name, maxLength);
    }

    private static void isBlank(String name) {
        HasContentsValidator.validate(name);
    }

    private static void isInBoundLength(String name, int maxLength) {
        if (name.length() > maxLength) {
            throw new OutOfBoundCarName();
        }
    }

}
