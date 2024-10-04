package carracing.domain.record;

import carracing.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundRecord {
    private final List<Car> cars = new ArrayList<>();

    private RoundRecord(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static RoundRecord from(List<Car> cars) {
        return new RoundRecord(cars);
    }

    public List<Car> getCars() {
        return cars.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getLeadingCar() {
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(calculateMaxPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
