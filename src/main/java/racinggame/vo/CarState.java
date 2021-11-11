package racinggame.vo;

import java.util.Objects;

public class CarState {

    private final String name;
    private int position;

    public CarState(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String assignName() {
        return name;
    }

    public int currentPosition() {
        return position;
    }

    public CarState move() {
        return new CarState(name, ++position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarState carState = (CarState) o;
        return position == carState.position && Objects.equals(name, carState.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
