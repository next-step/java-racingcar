package racingcar;

import java.util.Objects;

public class CarState {
    private final String name;
    private final int distance;

    public CarState(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CarState carState = (CarState) object;
        return distance == carState.distance && Objects.equals(name, carState.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
