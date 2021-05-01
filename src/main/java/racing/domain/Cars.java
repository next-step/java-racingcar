package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MINIMUM_NUMBER = 1;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames, MovableStrategy movableStrategy) {
        if (carNames.length < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("최소 1대 이상 필요합니다.");
        }
        return new Cars(mapCars(carNames, movableStrategy));
    }

    private static List<Car> mapCars(String[] carNames, MovableStrategy movableStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, movableStrategy));
        }
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
