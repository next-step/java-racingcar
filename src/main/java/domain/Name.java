package domain;

import java.util.Objects;

public class Name {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        this.name = validateName(name);
    }

    public static String validateName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty() || trimmedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자, 최대 5글자 이내여야 합니다.");
        }
        return trimmedName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name)o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * getter
     */
    public String getName() {
        return name;
    }
}
