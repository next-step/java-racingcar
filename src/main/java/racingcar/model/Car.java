package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.Objects;

public class Car {
    private final Status status;

    public Car(ForwardNumber number) {
        this.status = Status.extractByNumber(number);
    }

    protected Car(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return status == car.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
