package racingcar.model;

import java.util.Random;

import static racingcar.model.CarStatus.RUN;
import static racingcar.model.CarStatus.STOP;

public class Car {
    private final Random random;

    private int distance = 0;

    public Car() {
        this.random = new Random();
    }

    public Car(long seed) {
        this.random = new Random(seed);
    }

    public CarStatus move() {
        int num = random.nextInt(10);
        
        if (num >= 4) {
            this.distance++;
            return RUN;
        }
        return STOP;
    }

    public int distance() {
        return this.distance;
    }
}
