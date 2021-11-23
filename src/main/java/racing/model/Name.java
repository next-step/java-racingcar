package racing.model;

import java.util.Objects;

/*
 *
 * Name
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
 */
public class Name {

    private static final int LENGTH_LIMIT = 5;
    private final String name;

    public Name(String inputName) {
        this.name = validCarName(inputName);
    }

    private String validCarName(String inputString) {
        if (inputString.length() <= LENGTH_LIMIT) {
            return inputString;
        }
        throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
