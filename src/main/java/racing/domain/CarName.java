package racing.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public String getName() {
        return name;
    }

    public CarName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("car name cannot be empty");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("car name length shouldn't be longer than 5");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(name, carName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
