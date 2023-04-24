package study;

import java.util.Objects;

public class Name {
    private String name;
    private static final int MAX_LENGTH_OF_NAME = 5;
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

    public Name(String name) {
        if (name.length() >= MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("사용자의 이름의 길이는 5이상으로 작성할수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
