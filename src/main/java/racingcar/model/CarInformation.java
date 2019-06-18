package racingcar.model;

import java.util.Objects;

public class CarInformation {
    private String name;
    private Position position;

    public CarInformation(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public CarInformation(String name) {
        this(name, Position.valueOf(0));
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarInformation)) return false;
        CarInformation that = (CarInformation) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
