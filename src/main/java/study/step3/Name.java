package study.step3;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new InvalidParameterException("이름의 길이는 " + NAME_MAX_LENGTH + "를 초과할 수 없습니다.");
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

    public final String toString() {
        return name;
    }
}
