package newRacingCar.domain;

import java.util.Objects;

public class Name {
    private final int MAX_NAME_LENGTH = 5;

    private String name;

    Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5글자가 넘을 수 없습니다.");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return MAX_NAME_LENGTH == name1.MAX_NAME_LENGTH && Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_NAME_LENGTH, name);
    }
}
