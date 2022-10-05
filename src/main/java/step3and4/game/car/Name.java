package step3and4.game.car;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " : ";
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
