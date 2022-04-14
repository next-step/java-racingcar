package racingcar.model;

import java.util.Objects;

public class Name {
    private static final String DEFAULT_NAME = "car";
    private static final int MAX_LENGTH = 5;
    private static final String MAX_LENGTH_EXCEED_MESSAGE = "길이 최대값을 초과했습니다.";

    private final String name;

    public Name() {
        this(DEFAULT_NAME);
    }

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_EXCEED_MESSAGE);
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return Objects.equals(name, ((Name) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
