package controller;

import java.util.Arrays;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateName(String[] names) {
        Arrays.stream(names).filter(this::isInvalid).findAny().ifPresent((name) -> {
            throw new IllegalArgumentException(name);
        });
    }

    private boolean isInvalid(String name) {
        return name == null || name.isBlank() || name.length() > MAX_CAR_NAME_LENGTH;
    }

}
