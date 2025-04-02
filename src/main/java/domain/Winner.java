package domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 우승자 클래스
 */
public class Winner {

    public List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return cars.stream()
            .map(car -> car.name)
            .collect(Collectors.joining(", "));
    }
}
