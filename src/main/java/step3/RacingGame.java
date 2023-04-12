package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RandomGenerator randomGenerator;
    List<Car> cars;

    public RacingGame() {
        randomGenerator = new RandomGenerator();
        cars = new ArrayList<>();
    }

    public void initCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public Integer getRandomValue() {
        return randomGenerator.getValue();
    }

    public List<Car> getCars() {
        return cars;
    }
}
