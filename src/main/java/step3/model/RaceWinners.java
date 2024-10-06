package step3.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinners {
    private final List<Car> winners;

    public RaceWinners(final List<Car> cars) {
        this.winners = determineWinners(cars);
    }

    private List<Car> determineWinners(final List<Car> cars) {
        return cars.stream()
                .filter(car -> car.isSameMaxMovement(getMaxMovement(cars)))
                .collect(Collectors.toList());
    }

    private int getMaxMovement(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(Movement.DEFAULT_COUNT);
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
