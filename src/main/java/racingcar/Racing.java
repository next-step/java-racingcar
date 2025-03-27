package racingcar;

import racingcar.participant.Car;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Racing {
    private final Set<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public void playRound() {
        cars.forEach(Car::play);
    }

    public List<Car> getCars() {
        return this.cars.stream().sorted(Comparator.comparing(Car::print)).collect(Collectors.toList());
    }

    public List<Car> getFarthestCars() {
        int maxDistance = getCars().stream().mapToInt(Car::getDistance).max().orElse(0);

        return getCars().stream().filter(car -> car.getDistance() == maxDistance).collect(Collectors.toList());
    }
}
