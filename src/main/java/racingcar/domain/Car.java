package racingcar.domain;

import racingcar.dto.CarRecord;
import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    private static final int INIT_POSITION = 0;

    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void moves(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position = position.plus();
        }
    }

    boolean isWinner(CarPosition maxPosition) {
        return position.equals(maxPosition);
    }

    CarPosition getMaxPosition(CarPosition maxPosition) {
        if (position.isLessThan(maxPosition)) {
            return maxPosition;
        }
        return this.position;
    }

    public CarRecord generateRecord() {
        return new CarRecord(name.getName(), position.getPosition());
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
