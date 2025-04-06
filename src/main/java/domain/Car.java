package domain;

import java.util.Objects;

public class Car{
    private static final int STANDARD_VALUE = 4;
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void moveBy(int value) {
        if (value > STANDARD_VALUE) {
            this.position++;
        }
    }

    public boolean isPosition(int value) {
        return this.position == value;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {return this.name;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {return false;}
        final Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
