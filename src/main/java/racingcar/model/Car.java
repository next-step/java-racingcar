package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.Objects;

public class Car {
    private Status currentStatus;

    public Car() {
    }

    protected Car(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void move(ForwardNumber forwardNumber) {
        this.currentStatus = Status.extractByNumber(forwardNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return currentStatus == car.currentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentStatus);
    }
}
