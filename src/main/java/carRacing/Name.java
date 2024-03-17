package carRacing;

import java.util.Objects;

public class Name {

    private String name;
    private static final int MAX_LENGTH = 5;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }
    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof  Position)) {
            return false;
        }
        Name targetName = (Name) obj;
        return getName() == targetName.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
