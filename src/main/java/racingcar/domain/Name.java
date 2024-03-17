package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        assertValidName(name);
        this.name = name;
    }

    public Name(Name name) {
        this.name = name.name;
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

        Name target = (Name) o;


        return Objects.equals(this.name, target.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void assertValidName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("차량의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

}
