package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public List<Car> getCarList() {
        return cars;
    }

    public List<String> getLeadingCarNameList() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getCarName).collect(Collectors.toList());
    }
}
