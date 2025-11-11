package study.racing.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = DEFAULT_POSITION;
    }

    public void move(int randonValue) {
        if (randonValue >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{name= " + name.getValue() + ", position=" + position + "}";
    }
}
