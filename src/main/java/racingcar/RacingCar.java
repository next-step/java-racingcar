package racingcar;

import racingcar.movingstrategy.MovingStrategy;

import java.util.Objects;

public class RacingCar {

    private final Position position;
    private final MovingStrategy movingStrategy;

    public RacingCar(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        this.position = new Position();
    }

    public Position move() {
        if (movingStrategy.movable()) {
            position.forward();
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
