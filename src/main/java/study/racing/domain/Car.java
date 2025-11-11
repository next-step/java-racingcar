package study.racing.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public void move(int randonValue) {
        if (randonValue >= MOVE_CONDITION) {
            this.position = position.increase();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{name= " + name.getValue() + ", position= " + position.getValue() + "}";
    }
}
