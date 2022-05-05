package racingcar.model;

import java.util.Objects;

public class RacingCar {
    private RacingCarPosition status;
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    public RacingCar() {
        this.status = new RacingCarPosition();
    }

    public RacingCar(RacingCarPosition status) {
        this.status = status;
    }

    public void move() {
        this.status = status.add();
    }

    public int getStatus() {
        return this.status.getValue();
    }

    public boolean isMovable() {
        return movableStrategy.isMovable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(status, racingCar.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
