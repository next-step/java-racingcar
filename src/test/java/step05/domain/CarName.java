package step05.domain;

import validator.HasContentsValidator;

public class CarName {
    private final String name;

    private CarName(String name) {
        isBlank(name);
        this.name = name;
    };

    public static CarName of(String name) {
        return new CarName(name);
    }

    private static void isBlank(String name) {
        HasContentsValidator.validate(name);
    }



}
