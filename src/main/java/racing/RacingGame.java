package racing;

import java.util.Arrays;
import java.util.stream.IntStream;
import racing.movestrategies.RandomMoveStrategy;

class RacingGame {

    private static final String ILLEGAL_CARS = "경주할 자동차 수를 정확히 입력하세요.";
    private static final String ILLEGAL_TRIES = "경주할 거리를 정확히 입력하세요.";

    private final Car[] cars;
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

    protected int[] doRace() {
        return raceAllSteps(tries);
    }

    protected Car[] createCars(int numberOfCars) {
        Car[] cars = new Car[numberOfCars];
        IntStream.range(0, numberOfCars)
            .forEach(i -> cars[i] = new Car(new RandomMoveStrategy()));

        return cars;
    }

    private int[] raceAllSteps(int tries) {
        IntStream.range(0, tries)
            .forEach(i -> race1Step());

        return gatherResults();
    }

    private void race1Step() {
        for (Car car : cars) {
            car.move();
        }
    }

    private int[] gatherResults() {
        return Arrays.stream(cars)
            .map(Car::getPosition)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
