package domain;

import java.util.Objects;

public class RacingCar {
    private CarDistance carDistance;
    private CarName carName;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.carName = new CarName(name);
        this.carDistance = new CarDistance(distance);
    }

    public CarDistance getCarDistance() {
        return carDistance;
    }

    public CarName getCarName() {
        return carName;
    }

    public void move(RacingCarMoveBehavior racingCarMoveBehavior) {
        if (racingCarMoveBehavior.isMoving()) {
            carDistance.increase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carDistance == racingCar.carDistance &&
                Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carDistance, carName);
    }
}
