package study.racing.domain;

import study.racing.exception.InvalidCarNameException;

public class Name {

    public static final String INVALID_NAME_MESSAGE = "car name length must not greater than ";
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new InvalidCarNameException(INVALID_NAME_MESSAGE + NAME_LENGTH_LIMIT);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
