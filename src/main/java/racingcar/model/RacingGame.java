package racingcar.model;

import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.view.InputResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final List<Car> cars;
    private final int lastRound;

    public RacingGame(InputResult inputResult) {
        cars = new ArrayList<>();
        IntStream.range(0, inputResult.getNumberOfCars())
                .forEach((int i) -> cars.add(new Car()));
        this.lastRound = inputResult.getNumberOfTries();
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public int getLastRound() {
        return this.lastRound;
    }

    public void play() {
        cars.forEach((Car car) -> car.run(new RandomNumber()));
    }

    public List<Integer> getCurrentStatus() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
