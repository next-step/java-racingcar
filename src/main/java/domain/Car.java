package domain;

import strategy.MovableStrategy;

import java.util.List;
import java.util.Objects;

public class Car {
    private final String name;
    private Location location;

    public Car(final String name) {
        this(name, new Location());
    }

    public Car(final String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            location.moveToForward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    public String toStringForPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        stringBuilder.append(location.toStringForPrint());
        return stringBuilder.toString();
    }

    public Location max(Location maxLocation) {
        return location.max(location, maxLocation);
    }

    public void isWinner(List<String> winners, Location maxLocation) {
        if (location.equals(maxLocation)) {
            winners.add(name);
        }
    }

}
