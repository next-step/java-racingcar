package racingcar.domain;

import java.util.Objects;

public class CarStat {
    private final Name name;
    private final Position position;

    public CarStat(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CarStat carStat = (CarStat)o;
        return Objects.equals(name, carStat.name) && Objects.equals(position, carStat.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
