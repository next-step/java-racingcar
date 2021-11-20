package racingcar;

import racingcar.model.Car;
import racingcar.view.InputResult;

import java.util.ArrayList;
import java.util.List;
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
}
