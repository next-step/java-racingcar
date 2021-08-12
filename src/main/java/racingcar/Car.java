package racingcar;

import java.util.Objects;

public class Car {

    private Position position;
    private Name name;

    public Car(String name) {
        this.position = new Position(0);
        this.name = new Name(name);
    }

    public Car(Car car) {
        this.position = new Position(car.position);
        this.name = new Name(car.name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position = position.increase();
        }
    }

    int getCarPosition() {
        return position.getPosition();
    }

    String getCarName() {
        return name.getName();
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
