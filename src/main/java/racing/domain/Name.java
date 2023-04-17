package racing.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (isNameBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상이어야 합니다.");
        }
        if (isNameOverLimit(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static boolean isNameBlank(String name) {
        return name.isBlank();
    }

    private static boolean isNameOverLimit(String name) {
        return name.length() > MAX_NAME_LENGTH;
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
