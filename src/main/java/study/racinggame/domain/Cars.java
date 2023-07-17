package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final int gameCount;
    private int currentCount;

    public Cars(int numberOfCars, int gameCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
        currentCount++;
    }

    public boolean isEndGame() {
        return currentCount >= gameCount;
    }
}
