package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnersName() {
        final int maxLocation = findMaxLocation();
        final List<Car> winners = findWinners(maxLocation);
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private List<Car> findWinners(final int maxLocation) {
        return cars.stream()
            .filter(car -> car.getLocation() == maxLocation)
            .collect(Collectors.toList());
    }

    private int findMaxLocation() {
        return cars.stream()
            .mapToInt(Car::getLocation)
            .max().getAsInt();
    }
}
