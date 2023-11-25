package study.race.model;

import java.util.Random;

public class Racing {

    private static final int RANDOM_LIMIT_NUMBER = 10;

    private Random random;
    private Cars cars;

    public Racing(Cars cars) {
        this.random = new Random();
        this.cars = cars;
    }

    public void start() {
        for (int i = 0; i < this.cars.size(); i++) {
            int movingDistance = random.nextInt(RANDOM_LIMIT_NUMBER);
            this.cars.moveCarAt(i, movingDistance);
        }
    }

    public Cars getRaceResult() {
        return this.cars;
    }
}
