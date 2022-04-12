package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position = position.move();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
