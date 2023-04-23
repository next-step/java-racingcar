package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_STANDARD = 5;
    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    private String validateName(String carName) {
        if (carName.length() > NAME_STANDARD || carName.isEmpty()) {
            throw new IllegalArgumentException("입력 조건을 만족하지 않습니다.");
        }
        return carName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
