package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int roundCount;

    private final List<Car> cars;

    private RacingGame(int roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        this.cars = cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static RacingGame setUp(int roundCount, int carCount) {
        return new RacingGame(roundCount, initialCars(carCount));
    }

    private static List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.create());
        }
        return cars;
    }
}
