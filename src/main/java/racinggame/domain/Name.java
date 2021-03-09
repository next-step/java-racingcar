package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }

        this.name = name;
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
