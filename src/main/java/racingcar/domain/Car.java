package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int MOVE_DISTANCE = 1;

    private Integer location;
    private final CarName name;

    private Car(int location, CarName name) {
        this.location = location;
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(0, CarName.from(name));
    }

    public static Car from(Car car) {
        return new Car(car.location, car.name);
    }

    public void moveForward() {
        location += MOVE_DISTANCE;
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(location, car.location) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }
}
