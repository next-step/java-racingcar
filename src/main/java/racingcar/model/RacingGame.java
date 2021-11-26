package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int lastRound;

    public RacingGame(List<Car> cars, int lastRound) {
        this.cars = cars;
        this.lastRound = lastRound;
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public int getLastRound() {
        return this.lastRound;
    }

    public void play() {
        cars.forEach((Car car) -> car.run(new RandomMoveStrategy()));
    }

    public List<Integer> getCurrentStatus() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car findWinner() {
        Collections.sort(cars);

        return cars.get(0);
    }
}
