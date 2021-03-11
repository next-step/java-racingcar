package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    final List<Car> cars;

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
}
