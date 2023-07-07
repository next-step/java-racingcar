package racing.model;

import racing.exception.IllegalCarNameException;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalCarNameException();
        }
    }

    public String getName() {
        return name;
    }
}
