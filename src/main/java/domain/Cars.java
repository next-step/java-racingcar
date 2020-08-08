package domain;

import strategy.MovableStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String SEPARATION_BETWEEN_NAMES = " , ";

    private final List<Car> cars;

    public Cars(Set<String> players, MovableStrategy movableStrategy) {
        this.cars = players.stream()
                .map(it -> Car.of(it, movableStrategy))
                .collect(Collectors.toList());
    }

    public List<Car> race() {
        for (Car car : cars) {
            car.move();
        }

        return cars;
    }

    public String getWinners() {
        Integer maxLocation = this.getMaxLocation();

        return cars.stream()
                .filter(it -> it.getLocation() == maxLocation)
                .map(Car::getPlayer)
                .collect(Collectors.joining(SEPARATION_BETWEEN_NAMES));
    }

    private Integer getMaxLocation() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .map(Car::getLocation)
                .orElse(0);
    }
}
