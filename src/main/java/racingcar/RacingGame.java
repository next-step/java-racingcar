package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int COUNT_UP_TARGET = 4;

    private RandomGenerator randomGenerator;
    private List<Car> cars;

    public RacingGame(int carCount, RandomGenerator randomGenerator) {
        this.cars = createCars(carCount);
        this.randomGenerator = randomGenerator;
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
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

    public String generateRaceResultString(Car car) {
        StringBuilder result = new StringBuilder("|");
        for (int i = 0; i < car.getPosition(); i++) {
            result.append("-");
        }
        return result.toString();
    }
}
