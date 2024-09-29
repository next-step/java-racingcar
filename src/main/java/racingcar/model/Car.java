package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Car {
    private final List<Status> statuses;

    public Car() {
        this.statuses = new ArrayList<>();
    }

    public Car(List<Status> statuses) {
        this.statuses = statuses;
    }

    public void move(ForwardNumber forwardNumber) {
        this.statuses.add(Status.extractByNumber(forwardNumber));
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

    public String currentStatus() {
        return this.statuses
                .stream()
                .map(Status::printStatus)
                .collect(Collectors.joining());
    }
}
