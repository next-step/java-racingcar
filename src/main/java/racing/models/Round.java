package racing.models;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private final List<Car> cars;

    public static Round createFrom(List<Car> cars) {
        return new Round(cars.stream()
                .map(Car::clone)
                .collect(Collectors.toList())
        );
    }

    private Round(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream().filter(e -> e.getDistance() == getMaxDistance()).collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream().map(Car::getDistance).max(Integer::compare).orElse(-1);
    }
}
