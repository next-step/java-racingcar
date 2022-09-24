package controller;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateName(String[] names) {
        for (int i = 0; i < names.length; i++) {
            validateName(names[i]);
        }
    }

    private void validateName(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalid(String name) {
        return name == null || name.length() == 0 || name.length() > MAX_CAR_NAME_LENGTH;
    }

}
