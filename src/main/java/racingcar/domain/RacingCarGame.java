package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {
    private static final int BOUND = 10;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> createCars(int carCount) {
        cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public GameResult execute() {
        cars.forEach(car -> {
            int random = new Random().nextInt(BOUND);
            car.move(random);
        });

        return new GameResult(cars);
    }
}

