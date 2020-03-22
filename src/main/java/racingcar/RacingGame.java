package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int tryCount;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int numberOfCars, int tryCount) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.tryCount = tryCount;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            moveAll();
        }
    }

    public List<Car> getResult() {
        return cars;
    }

    private void moveAll() {
        cars.forEach(Car::move);
    }

}
