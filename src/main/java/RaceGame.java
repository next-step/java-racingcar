import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;
    private final Cars cars;

    RaceGame(List<Car> cars) {
        this(new Cars(cars));
    }

    RaceGame(Cars cars) {
        this.cars = cars;
    }

    Cars cars() {
        return cars;
    }

    void race() {
        cars.race(RANDOM, MAX_RANDOM_VALUE);
    }

    Winners getWinners() {
        return cars.winners();
    }
}
