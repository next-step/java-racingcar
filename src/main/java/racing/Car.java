package racing;

import racing.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.addOne();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
