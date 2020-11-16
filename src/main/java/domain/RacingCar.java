package domain;

import java.util.Objects;

public class RacingCar {
    private final static int MAX_NAME_LENGTH = 5;
    private int distance;
    private String name;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다. ");
        }
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(RacingCarMoveBehavior racingCarMoveBehavior) {
        if (racingCarMoveBehavior.isMoving()) {
            this.distance++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return distance == racingCar.distance &&
                Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }
}
