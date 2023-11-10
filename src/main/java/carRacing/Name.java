package carRacing;

import java.util.InputMismatchException;
import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name.length() > 5) {
            throw new InputMismatchException("이름은 5글자 이상일 수 없습니다.");
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Name carName = (Name) obj;
        return carName.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
