package racingcar.car;

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

    public String getName() { return name; }

    public void move() {
        this.status = this.status + randomForward();
    }
}