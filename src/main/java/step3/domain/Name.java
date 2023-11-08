package step3.domain;

import step3.exception.CarNameExceedException;

public class Name {

    private static final int NAME_LENGTH_BOUND = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new CarNameExceedException();
        }
    }

    public String name() {
        return name;
    }

}
