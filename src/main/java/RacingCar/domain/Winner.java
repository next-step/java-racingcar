package RacingCar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        var car = this.cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException());

        int max = car.getPosition();

        return cars.stream()
                .filter(x -> x.isSamePosition(max))
                .collect(Collectors.toList());
    }
}
