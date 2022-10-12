package racing_game.domain;

import java.util.Objects;
import racing_game.core.exception.InvalidCarNameException;

public class CarName {

    private final String holder;

    public CarName(String name) {
        if (!isCarNameFormat(name)) {
            throw new InvalidCarNameException("car name length should be less than 5");
        }
        this.holder = name;
    }

    public static boolean isCarNameFormat(String name) {
        return name != null && name.length() <= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarName carName = (CarName) o;

        return Objects.equals(holder, carName.holder);
    }

    @Override
    public int hashCode() {
        return holder != null ? holder.hashCode() : 0;
    }

    // for logging
    @Override
    public String toString() {
        return holder;
    }
}
