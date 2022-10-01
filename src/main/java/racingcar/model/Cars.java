package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = initCars(names);
    }

    private List<Car> initCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> move() {
        cars.forEach(car -> car.move(new CarCondition()));
        return cars;
    }

    public List<Car> getWinners() {
        return Car.getWinner(cars);
    }
}
