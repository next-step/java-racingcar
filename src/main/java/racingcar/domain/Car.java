package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    public static final int INIT_POSITION = 0;

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void moves(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position.plus();
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
