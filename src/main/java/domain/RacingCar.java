package domain;

import java.util.Objects;

public class RacingCar {
    private int distance;
    private CarName carName;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.carName = new CarName(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public CarName getCarName() {
        return carName;
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
                Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, carName);
    }
}
