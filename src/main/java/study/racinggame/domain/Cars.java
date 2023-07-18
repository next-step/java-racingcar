package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final int gameCount;
    private int currentCount;

    public Cars(List<String> carNames, int gameCount) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
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
