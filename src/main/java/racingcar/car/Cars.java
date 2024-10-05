package racingcar.car;

import racingcar.engine.RandomEngine;

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

    public static Cars createCars(CarName[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(Car.createCar(carName));
        }
        return of(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomEngine.createCarEngine());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxLocation = getMaxLocation();

        return cars.stream()
                .filter(car -> car.isSame(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.max(maxLocation);
        }
        return maxLocation;
    }
}
