package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racing.movestrategies.RandomMoveStrategy;

class RacingGame {

    private static final String ILLEGAL_CARS = "경주할 자동차 수를 정확히 입력하세요.";
    private static final String ILLEGAL_TRIES = "경주할 거리를 정확히 입력하세요.";

    private final List<Car> cars;
    private int tries;

    RacingGame(int numberOfCars, int tries) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException(ILLEGAL_CARS);
        }
        if (tries <= 0) {
            throw new IllegalArgumentException(ILLEGAL_TRIES);
        }
        this.cars = createCars(numberOfCars);
        this.tries = tries;
    }

    void doRaces() {
        IntStream.range(0, tries)
            .forEach(i -> doRace());
    }

    private void doRace() {
        for (Car car : cars) {
            car.move();
        }
    }

    protected List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        IntStream.range(0, numberOfCars)
            .forEach(i -> cars.add(new Car(new RandomMoveStrategy())));

        return cars;
    }

    List<Car> getCars() {
        return cars;
    }
}
