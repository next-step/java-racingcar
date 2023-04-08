package racingcar.model;

import static racingcar.model.CarStatus.RUN;
import static racingcar.model.CarStatus.STOP;

public class Car {
    private final Probability probability;

    private int distance = 0;

    public Car() {
        this.probability = new Probability();
    }

    public Car(long seed) {
        this.probability = new Probability(seed);
    }


    public CarStatus move() {
        if (probability.success()) {
            this.distance++;
            return RUN;
        }
        return STOP;
    }

    public int distance() {
        return this.distance;
    }
}
