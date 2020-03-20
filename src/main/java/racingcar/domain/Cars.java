package racingcar.domain;

import racingcar.RandomNumGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        createCars(carCount);
    }

    private void createCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveOnce(RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNumber = rng.generateNumberLessThan(10);
            boolean canRun = car.canRun(randomNumber);
            car.move(canRun);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}