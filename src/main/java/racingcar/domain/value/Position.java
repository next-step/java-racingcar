package racingcar.domain.value;

import racingcar.service.util.Validation;

import java.util.Objects;

public class Position {

    private int location;

    private Position(int location) {
        Validation.checkMinSize(location);

        this.location = location;
    }

    public static Position create(int location) {
        return new Position(location);
    }

    public void increaseLocation() {
        location++;
    }

    public boolean isGreaterThan(Position maxPosition) {
        return this.location >= maxPosition.location;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(location, position1.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(location);
    }


}
