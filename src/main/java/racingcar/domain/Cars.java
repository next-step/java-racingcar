package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void act() {
        for (Car car : cars) {
            car.act();
        }
    }

    public List<Integer> getCarPositions() {
        List<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }

    public static Cars fromCarCounts(int carCounts) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCounts; i++) {
            cars.add(new Car());
        }

        return new Cars(cars);
    }
}
