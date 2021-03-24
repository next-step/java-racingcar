package carRacing.model;

import java.util.Arrays;
import java.util.Objects;

public class Name {
    private static final String DELIMITER = ",";
    private String name;


    public Name(String name) {
        if (name.trim().length() == 0 || Arrays.stream(name.split(DELIMITER)).anyMatch(s -> s.length() == 0)) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (Arrays.stream(name.split(DELIMITER)).anyMatch(s -> s.length() > 5 || s.length() < 1)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
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

    @Override
    public String toString() {
        return name;
    }
}
