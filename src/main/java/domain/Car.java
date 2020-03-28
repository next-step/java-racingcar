package domain;

import strategy.MovableStrategy;

import java.util.List;
import java.util.Objects;

public class Car {

    private static final int INITIAL_LOCATION = 0;

    private final String name;
    private int location;

    public Car(final String name) {
        this(name, INITIAL_LOCATION);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            location++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        stringBuilder.append(locationToString());
        return stringBuilder.toString();
    }

    private String locationToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public int isMaxLocation(int maxLocation) {
        return Math.max(location, maxLocation);
    }

    public void isWinner(List<String> winners, int maxLocation) {
        if (location == maxLocation) {
            winners.add(name);
        }
    }
}
