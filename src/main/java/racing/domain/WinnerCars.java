package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerCars {
    private final List<Car> cars;

    public WinnerCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<String> selectWinnersName() {
        int highestScore = findHighestScore();

        return cars.stream()
                .filter(car -> car.getPosition() == highestScore)
                .map(Car::getPlayerName)
                .collect(Collectors.toSet());
    }

    private int findHighestScore() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(-1);
    }

}
