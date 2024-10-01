package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.util.NumberCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Car {
    private final List<Status> statuses;

    public Car() {
        this.statuses = new ArrayList<>();
    }

    public Car(List<Status> statuses) {
        this.statuses = statuses;
    }

    public void move(NumberCreator numberCreator) {
        this.statuses.add(numberCreator.number().status());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(statuses, car.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses);
    }

    public List<Status> currentStatus() {
        return this.statuses;
    }
}
