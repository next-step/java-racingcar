package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public Cars move() {
        List<Car> movedCars = cars.stream()
                .map(car -> car.move(new RandomMoveStrategy()))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }
}
