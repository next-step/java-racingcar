package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private String name;
    private int location;

    public Car(String name, int location) {
        validateParameter(name, location);
        this.name = name;
        this.location = location;
    }

    public void go() {
        location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void validateParameter(String name, int location) {
        if (name.length() > 5 || name.length() <= 0) {
            throw new IllegalArgumentException("이름이 올바르지 않습니다. (5자 이하)");
        }

        if (location < 0) {
            throw new IllegalArgumentException("시작 위치는 0이상이어야 합니다.");
        }
    }

    public boolean isEqualLocation(Car car) {
        return this.location == car.location;
    }

    @Override
    public int compareTo(Car c) {
        return c.location - this.location;
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

}
