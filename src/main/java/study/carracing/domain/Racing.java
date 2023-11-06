package study.carracing.domain;

import study.carracing.util.RandomGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final RacingCars racingCars;

    public Racing(int carCount) {
        this.racingCars = addRacingCars(carCount);
    }

    private RacingCars addRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(new RandomGeneratorImpl()));
        }

        return new RacingCars(cars);
    }

    public void start(int tryCount) {
        racingCars.move(tryCount);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
