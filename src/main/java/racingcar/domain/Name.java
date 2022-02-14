package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_SIZE = 5;
    private static final String NOT_NULL_MESSAGE = "자동차 이름이 빈값입니다!";
    private static final String OVER_SIZE_MESSAGE = "자동차 이름의 길이가 5를 초과했습니다!";

    private final String name;

    public Name(String name) {
        verifyCorrectNameSize(name);
        this.name = name;
    }

    private void verifyCorrectNameSize(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_MESSAGE);
        }
        if (NAME_SIZE < name.length()) {
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
        }
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
        return name.hashCode();
    }
}
