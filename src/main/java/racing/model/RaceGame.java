package racing.model;

import java.util.List;
import java.util.Random;

public class RaceGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final Cars cars;

    public RaceGame(List<Car> cars) {
        this(new Cars(cars));
    }

    public RaceGame(Cars cars) {
        this.cars = cars;
    }

    public Cars cars() {
        return cars;
    }

    public void race() {
        cars.race(RANDOM, MAX_RANDOM_VALUE);
    }

    public Winners getWinners() {
        return cars.winners();
    }
}
