package step3.domain;

import java.util.Objects;

public class Car {

    private Name name;
    private Position position;
    private final int ADVANCED_VALUE = 4;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position advanceCar(int randomValue) {
        if (isAdvanced(randomValue)) {
            this.position.advancedPosition();
            return this.position;
        }
        return this.position;
    }

    public Position currentPosition() {
        return this.position;
    }

    public Name currentName() {
        return this.name;
    }

    public boolean isMaxPosition(Position position) {
        return this.position.currentPosition() == position.currentPosition();
    }

    public Position maxPosition(Position position) {
        if(position.currentPosition() < this.position.currentPosition()) {
            return this.position;
        }
        return position;
    }

    private boolean isAdvanced(int value) {
        return value >= ADVANCED_VALUE;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                ", ADVANCED_VALUE=" + ADVANCED_VALUE +
                '}';
    }
}
