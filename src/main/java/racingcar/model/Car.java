package racingcar.model;

import java.util.Objects;

public class Car {
    private CarName name;
    private Distance distance;

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = new Distance(distance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance.forward();
        }
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance.getDistance() == maxDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance.getDistance() == car.distance.getDistance() && Objects.equals(name.getName(), car.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

}
