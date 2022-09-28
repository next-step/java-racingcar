package racing.model;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

}
