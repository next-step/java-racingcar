package racingcar;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(int carCount) {
        cars = new ArrayList<>();
        createCars(carCount);
    }

    private void createCars(int carCount) {
        for(int i = 0; i < carCount; i++) {
                cars.add(new Car(new RandomNumberMovingStrategy(RandomGenerator.getInstance())));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsSize() {
        return cars.size();
    }
}
