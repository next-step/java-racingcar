package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private CarName name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position = position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getSteps();
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

    @Override
    public int compareTo(Car anotherCar) {
        return position.compareTo(anotherCar.position);
    }
}
