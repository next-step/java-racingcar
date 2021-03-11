package step3.domain;

import java.util.Objects;

import static step3.util.Validator.isNullAndIsBlank;
import static step3.util.Validator.isValidNameLength;

/**
 * 데이터의 관리를 위한 immutable object
 */
public class Name {

    private final String name;

    public Name(final String name) {
        if(isNullAndIsBlank(name)) {
            throw new IllegalArgumentException("이름 비어있음");
        }
        if(isValidNameLength(name)) {
            throw new IllegalArgumentException("5글자 넘음");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
