package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Car {
    private final String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    public ResultCar getResult() {
        return new ResultCar(name, location);
    }

    public void play(MoveChecker moveChecker) {
        if (moveChecker.isMoving()) {
            this.location++;
        }
    }

    public int getMaxLocation(int location) {
        if (this.location > location) {
            return this.location;
        }
        return location;
    }

    public void addCarNameIfEqualLocation(List<String> list, int location) {
        if (this.location == location) {
            list.add(name);
        }
    }
}
