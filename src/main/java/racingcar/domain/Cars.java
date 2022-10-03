package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Distances move() {
        Distances distances = new Distances();
        for (Car car : cars) {
            distances.add(car.move(Moving.create()));
        }
        return distances;
    }
}
