package racingcar.domain;

import java.util.ArrayList;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars fromNames(List<String> names) {
        return createCars(names.stream()
                .map(Car::new)
                .toList());
    }

    private static Cars createCars(List<Car> names) {
        return new Cars(names);
    }

    public void moveCars(RandomMoveStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }


}
