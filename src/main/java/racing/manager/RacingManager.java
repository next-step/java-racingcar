package racing.manager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import racing.model.Cars;

public class RacingManager {

    private static final int DEFAULT_BOUND = 10;

    private final Cars cars;

    public RacingManager(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return this.cars;
    }

    public Cars turn() {
        for (int i = 0; i < cars.size(); i++) {
            int value = ThreadLocalRandom.current().nextInt(DEFAULT_BOUND);
            this.cars.moveOneStepMoreThanCriterion(i, value);
        }

        return this.cars;
    }

    public List<String> getWinnerNames() {
        return this.cars.getWinnerNames();
    }

}
