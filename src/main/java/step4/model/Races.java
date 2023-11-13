package step4.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Races {

    private final List<Car> cars;

    public Races(List<String> carNames) {
        this.cars = carNames.stream()
                .map(name -> new Car(new Name(name), new Position(0)))
                .collect(Collectors.toList());
    }

    public void start(MoveStrategy moveStrategy) {
        this.cars.forEach(car -> car.go(moveStrategy));
    }

    public List<Car> getWinners() {
        Map<Integer, List<Car>> mappedByStatus = this.cars.stream().collect(Collectors.groupingBy(car -> car.getPosition().getCurrentStatus()));
        return mappedByStatus.get(Collections.max(mappedByStatus.keySet()));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
