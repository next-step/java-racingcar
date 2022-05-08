package racingcar.model;

import java.util.Objects;

public class RacingCar {
    private RacingCarPosition status;
    private RacingCarName name;

    public RacingCar() {
        this.status = new RacingCarPosition();
    }

    public RacingCar(RacingCarPosition status) {
        this.status = status;
    }

    public RacingCar(String name) {
        this.status = new RacingCarPosition();
        this.name = new RacingCarName(name);
    }

    public RacingCar(String name, RacingCarPosition status) {
        this.status = status;
        this.name = new RacingCarName(name);
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            this.status = status.add();
        }
    }

    public int getStatus() {
        return this.status.getValue();
    }

    public String getName() {
        return this.name.getValue();
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
