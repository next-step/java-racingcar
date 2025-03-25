package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final Cars cars;
    private final int numberOfRounds;
    private final StringBuilder result = new StringBuilder();

    public Racing(Cars cars, int numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
    }

    public void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            cars.moveAll();
            result.append(cars).append("\n");
        }
    }

    public List<String> getWinners() {
        return cars.getCarsWithMaxDistance()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return result.toString();
    }
}