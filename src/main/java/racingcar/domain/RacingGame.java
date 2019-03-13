package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int COUNT_UP_TARGET = 4;

    private RandomGenerator randomGenerator;
    private List<Car> cars;

    public RacingGame(List<String> names, RandomGenerator randomGenerator) {
        this.cars = createCars(names);
        this.randomGenerator = randomGenerator;
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>(names.size());
        names.forEach(name -> cars.add(new Car(name)));
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void run(Car car) {
        if (randomGenerator.getRandomValue() >= COUNT_UP_TARGET) {
            car.addPosition();
        }
    }
}
