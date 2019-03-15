package racinggame.domain;

import java.util.List;

import static java.util.stream.Collectors.*;

public class RacingResult {

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maximumPosition = getMaximumPosition();

        return cars.stream()
                .filter(c -> c.getPosition() == maximumPosition)
                .collect(toList());
    }

    int getMaximumPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.INITIAL_POSITION);
    }
}
