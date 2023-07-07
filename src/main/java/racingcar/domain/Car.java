package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private Position position;

    public Car(CarName name) {
        this(name, new Position());
    }

    Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int power) {
        if (canMove(power)) {
            updatePosition(this.position.increaseValue());
        }
    }

    private boolean canMove(int value) {
        return value >= MOVE_THRESHOLD;
    }

    private void updatePosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }

    public boolean isWinner(Position winnerPosition) {
        return this.position.equals(winnerPosition);
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
