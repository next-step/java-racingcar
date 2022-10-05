package step3and4.game.car;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        verifyLengthMustNotExceedFive();
        return value + " : ";
    }

    private void verifyLengthMustNotExceedFive() {
        if (value.length() > 5) {
            throw new IllegalStateException("이름은 5글자를 초과할 수 없다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
