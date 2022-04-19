package racing.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final int RANDOM_BOUND_UNDER = 10;
    private static final Random RANDOM = new Random();

    private final List<Car> cars = new LinkedList<>();

    public Game() {}

    public List<Car> equipRacingCar(final NumberOfCars numberOfCars) {
        for (int i = 0; i < numberOfCars.number; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void proceedRound() {
        cars.forEach(car -> car.run(RANDOM.nextInt(RANDOM_BOUND_UNDER)));
    }
}
