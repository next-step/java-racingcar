package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    private static final int INIT_POSITION = 0;

    private int position;
    private final String name;

    public Car(String name) {
        this(INIT_POSITION, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void moves(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
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
