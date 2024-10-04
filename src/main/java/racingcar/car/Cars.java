package racingcar.car;

import racingcar.engine.RandomEngine;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
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
        List<String> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (Car car : cars) {
            if (car.getCurrentLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public int getMaxLocation() {
        int maxLocation = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getCurrentLocation());
        }
        return maxLocation;
    }
}
