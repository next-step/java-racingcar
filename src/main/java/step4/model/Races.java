package step4.model;

import java.util.List;
import java.util.stream.Collectors;

public class Races {

    private final List<Car> cars;

    public Races(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new).collect(Collectors.toList());
    }

    public void start(int condition) {
        this.cars.forEach(car -> car.go(condition));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
