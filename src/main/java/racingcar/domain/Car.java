package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    private static final int INIT_POSITION = 0;
    private int position;

    public Car() {
        this.position = INIT_POSITION;
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (isMovable(movingStrategy)) {
            this.position++;
        }
    }

    private boolean isMovable(MovingStrategy movingStrategy) {
        return movingStrategy.isMovable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
