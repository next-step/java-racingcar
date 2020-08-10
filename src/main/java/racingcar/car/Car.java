package racingcar.car;

import static racingcar.random.GenerateRandom.randomForward;

public class Car {
    private int status = 1;

    public Car() {
    }

    public Car(int customStatus) {
        this.status = customStatus;
    }

    public int getStatus() {
        return status;
    }

    public void move() {
        this.status = this.status + randomForward();
    }
}