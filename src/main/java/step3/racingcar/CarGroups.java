package step3.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroups {

    private final List<Car> carGroups;

    public CarGroups(List<Car> carGroups) {
        this.carGroups = carGroups;
    }

    public List<String> getCarNames() {
        return this.carGroups.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions() {
        return this.carGroups.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public void move() {
        this.carGroups.forEach(Car::move);
    }
}
