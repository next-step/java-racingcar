package car.racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingWinners {

    private final List<Car> cars;

    public CarRacingWinners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> racingWinners() {
        Car carMostFast = getCarsInFastOrder().get(0);
        return getCarsInFastOrder().stream()
                .filter(car -> car.getForwardCount() == carMostFast.getForwardCount())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getCarsInFastOrder() {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getForwardCount).reversed())
                .collect(Collectors.toList());
    }
}
