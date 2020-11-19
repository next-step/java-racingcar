package racing.domain;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
    }

    private void validate(String trimName) {
        if (trimName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        if (trimName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공란일 수 없습니다.");
        }
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
