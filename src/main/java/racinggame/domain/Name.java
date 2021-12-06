package racinggame.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        if (value.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Name)) {
            return false;
        }

        Name name = (Name) obj;

        return this.value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    public String getName() {
        return value;
    }
}
