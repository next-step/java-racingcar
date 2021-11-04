package racingcar;

import java.util.Objects;

public class Car {
    private Status status;

    public Car() {
        this(new Status());
    }

    public Car(Status status) {
        this.status = status;
    }

    public void moveOrNot(int randomInt) {
        if (movable(randomInt)) {
            this.status = new Status(this.status.value() + 1);
        }
    }

    private boolean movable(int value) {
        return value > 3;
    }

    public int forwardCount() {
        return this.status.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return this.status.equals(car.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
