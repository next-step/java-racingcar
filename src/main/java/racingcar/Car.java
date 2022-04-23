package racingcar;

import java.util.List;
import java.util.Objects;

public class Car {
    private Position position;
    public final String name;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int at) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("Car name size should between 1 and 5");
        }
        this.name = name;
        this.position = new Position(at);
    }

    public void move() {
        position.move();
    }

    public String createTrack() {
        return position.createTrack();
    }

    public int compareMax(int max) {
        return position.compareMax(max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public boolean isWinner(int max) {
        return this.position.isMaxPosition(max);
    }
}
