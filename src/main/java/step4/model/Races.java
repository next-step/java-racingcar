package step4.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Races {

    private final List<Car> cars;

    public Races(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new).collect(Collectors.toList());
    }

    public void start(boolean isMovable) {
        this.cars.forEach(car -> car.go(isMovable));
    }

    public List<Car> getWinners() {
        Map<Integer, List<Car>> mappedByStatus = this.cars.stream().collect(Collectors.groupingBy(Car::getCurrentStatus));
        return mappedByStatus.get(Collections.max(mappedByStatus.keySet()));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
