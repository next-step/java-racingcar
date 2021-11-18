package step3;

import java.util.Objects;

public class Car {

    public static final int MOVABLE_COUNT = 4;
    public static final int DEFAULT_CAR_LOCATION_VALUE = 0;

    private int location;
    private final CarName name;

    public Car(String name) {
        this(name, DEFAULT_CAR_LOCATION_VALUE);
    }

    public Car(String name, int location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public Car move(int count) {
        if (count >= MOVABLE_COUNT) {
            location++;
        }
        return this;
    }

    public boolean isFarthestLocation(int farthestLocation) {
        return location >= farthestLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
