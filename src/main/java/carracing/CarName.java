package carracing;

import java.util.Objects;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        name = name.trim();
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("CarName can't exceed length 5: %s", name));
        }
        this.name = name;
    }

    public String getName() {
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
