package racingcarwinner.domain;

import java.util.Objects;

public class Car {

    private String name;
    private int location;

    private static final int CAR_NAME_LENGTH_STANDARD = 5;

    public Car(final String name, final int location) {
        if (isLengthGreaterThanStandard(name)) {
            throw new IllegalStateException("자동차 이름 길이 기준 초과 오류");
        }
        this.name = name;
        this.location = location;
    }

    public static Car createDefaultCar(final String name) {
        return new Car(name, 1);
    }

    public String name() {
        return name;
    }

    public int location() {
        return location;
    }

    private boolean isLengthGreaterThanStandard(String name) {
        return name.length() > CAR_NAME_LENGTH_STANDARD;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isPossibleToMove()) {
            this.location++;
        }
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location == maxLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
