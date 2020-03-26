package domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_LOCATION = 0;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int location;

    public Car(final String name) {
        this(name, INITIAL_LOCATION);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
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

}
