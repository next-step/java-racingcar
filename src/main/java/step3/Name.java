package step3;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH = 5;

    private String value;

    public Name(String value) {
        if (value.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Name)) {
            return false;
        }

        Name name = (Name) obj;

        return name.value == name.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    public String getName() {
        return value;
    }
}
