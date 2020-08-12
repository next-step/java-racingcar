package pobiRacingCar.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) { this.name = name.trim();
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

