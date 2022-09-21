package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> movedCars = cars.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());

        return new Cars(movedCars);
    }
}
