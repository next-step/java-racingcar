package racingcar.model;

import racingcar.util.RandomNumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of (int numberOfCar) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        return Cars.of(cars);
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Integer> getCarsPositions() {
        return cars.stream().map(car -> car.getPosition()).collect(Collectors.toList());
    }

    public void movable() {
        cars.forEach(car -> car.movable(RandomNumberUtils.executeRandomNumber()));
    }

}
