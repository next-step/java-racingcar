package step4.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> get() {
        Map<Integer, List<Car>> mappedByStatus = this.cars.stream().collect(Collectors.groupingBy(Car::getCurrentStatus));
        return mappedByStatus.get(Collections.max(mappedByStatus.keySet()));
    }
}
