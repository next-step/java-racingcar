package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(int numberOfCars) {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<List<Integer>> getResult() {
        return cars.stream()
                .map(Car::getRecord)
                .collect(Collectors.toList());
    }
}
