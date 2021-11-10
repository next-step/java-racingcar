package racingcar;

import util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private final Cars cars;

    public RacingManager(Cars cars) {
        this.cars = cars;
    }

    public List<CarState> progressRound() {
        return cars.stream().map(this::progressCar)
                .collect(Collectors.toList());
    }

    private CarState progressCar(Car car) {
        int randomNumber = RandomGenerator.generateNumberBetweenZeroToNine();

        return car.runOrStop(randomNumber);
    }
}
