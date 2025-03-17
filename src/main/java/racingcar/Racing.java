package racingcar;

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

    public Racing(Set<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.forEach(Car::play);
    }

    public List<Car> getCars() {
        return this.cars.stream().sorted(Comparator.comparing(Car::getName)).collect(Collectors.toList());
    }
}
