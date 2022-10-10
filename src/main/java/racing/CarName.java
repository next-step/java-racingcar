package racing;

import java.util.Objects;

public class CarName {
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public CarName(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new CarNameTooLongException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
