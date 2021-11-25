package racingcar.model;

import java.util.Objects;

public class Car {
    private String name;
    private int position;

    public Car() {
        this.position = 1;
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public int getPosition() {
        return this.position;
    }

    public void run(MoveStrategy randomMoveStrategy) {
        if (randomMoveStrategy.isMovable()) {
            this.position += 1;
        }
    }
}
