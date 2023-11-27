package study.race.model;

import java.util.Random;

public class Racing {

    private Random random;
    private Cars cars;

    public Racing(Cars cars) {
        this.random = new Random();
        this.cars = cars;
    }

    public void start() {
        for (int i = 0; i < this.cars.size(); i++) {
            this.cars.moveCarAt(i);
        }
    }

    public Cars getRaceResult() {
        return this.cars;
    }
}
