package racingcar.model;

import static racingcar.model.CarStatus.GO;
import static racingcar.model.CarStatus.STOP;

public class Car {
    private final ForwardDecider forwardDecider;
    private int distance = 0;

    public Car() {
        this.forwardDecider = new ForwardDecider();
    }

    public Car(long seed) {
        this.forwardDecider = new ForwardDecider(seed);
    }

    public CarStatus move() {
        if (forwardDecider.decide()) {
            this.distance++;
            return GO;
        }
        return STOP;
    }

    public int distance() {
        return this.distance;
    }
}
