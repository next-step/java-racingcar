package race;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.trim();
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
