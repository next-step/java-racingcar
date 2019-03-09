package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int COUNT_UP_TARGET = 4;

    private List<Car> cars;

    public RacingGame(int carCount) {
        this.cars = setCars(carCount);
    }

    private List<Car> setCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public boolean run(Car car, int randomValue) {
        if (randomValue >= COUNT_UP_TARGET) {
            car.addPosition();
            return true;
        }
        return false;
    }

    public int getRandomValue(int maxRange) {
        Random generator = new Random();
        return generator.nextInt(maxRange);
    }

    public String printRaceResult(Car car) {
        StringBuilder result = new StringBuilder("|");
        for (int i = 0; i < car.getPosition(); i++) {
            result.append("-");
        }
        return result.toString();
    }
}
