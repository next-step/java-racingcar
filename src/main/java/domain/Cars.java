package domain;

import strategy.MovableStrategy;
import strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final NumberGeneratorStrategy numberGeneratorStrategy;

    public Cars(Set<String> players, MovableStrategy movableStrategy, NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
        this.cars = players.stream()
                .map(it -> Car.of(it, movableStrategy))
                .collect(Collectors.toList());
    }

    public void race() {
        for (Car car : cars) {
            car.move(numberGeneratorStrategy.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinners() {
        Integer maxLocation = this.getMaxLocation();

        return cars.stream()
                .filter(it -> it.getLocation() == maxLocation)
                .map(Car::getPlayer)
                .collect(Collectors.joining(", "));
    }

    private Integer getMaxLocation() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .map(Car::getLocation)
                .orElse(0);
    }
}
