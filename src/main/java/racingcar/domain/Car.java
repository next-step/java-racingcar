package racingcar.domain;

import java.util.Objects;

import static racingcar.random.GenerateRandom.randomForward;

public class Car {
    private int status = 1;
    private final String name;

    public Car (String name) {
        this.name = name;
    }

    public Car(String name, int customStatus) {
        this.name = name;
        this.status = customStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() { return name; }

    public void move() {
        this.status = this.status + randomForward();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return status == car.status &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, name);
    }
}