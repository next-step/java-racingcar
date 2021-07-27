package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners valueOf(List<Car> cars) {
        return new Winners(cars);
    }

    public boolean isWinner(Car car) {
        return cars.contains(car);
    }

    public List<Name> getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
