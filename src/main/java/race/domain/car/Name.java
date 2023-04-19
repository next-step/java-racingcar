package race.domain.car;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_SIZE = 5;
    private final String name;

    public Name(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    String name() {
        return this.name;
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
