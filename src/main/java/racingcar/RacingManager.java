package racingcar;

import util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private final List<Car> cars;

    RacingManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> progressRound() {
        return cars.stream().map(this::progressCar)
                .collect(Collectors.toList());
    }

    private int progressCar(Car car) {
        int randomNumber = RandomGenerator.generateNumberBetweenZeroToNine();

        return car.runOrStop(randomNumber);
    }
}
