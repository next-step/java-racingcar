package racingCar.domains;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
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
