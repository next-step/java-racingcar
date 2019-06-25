package step3.game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars.stream()
                   .map(Car::new)
                   .collect(Collectors.toList());
    }

    public int getNumberOfWinners() {
        return cars.size();
    }
}
