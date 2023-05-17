package racingcar.domain;

import racingcar.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void allMove() {
        for (Car car : cars) {
            car.move(RandomNumber.getNumber());
        }
    }

    public List<Car> getHighestCars() {
        cars.stream()
                .max(Car::compareTo)
                .ifPresent(max -> cars.removeIf(car -> car.compareTo(max) < 0));
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
