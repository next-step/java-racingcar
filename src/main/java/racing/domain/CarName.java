package racing.domain;

import java.util.Objects;

import racing.exception.GameException;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new GameException("car name can't be empty");
        }

        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new GameException("car name length can't exceed " + CAR_NAME_MAX_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CarName{" +
               "name='" + name + '\'' +
               '}';
    }
}
