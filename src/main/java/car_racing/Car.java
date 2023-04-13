package car_racing;

import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int INITIAL_COUNT = 0;
    private static final int CAR_MOVE_BOUND = 4;

    private int moveCount = INITIAL_COUNT;

    private final NumberGenerator numberGenerator;

    public int getMoveCount() {
        return moveCount;
    }

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    void moveOrStop() {
        int randomInt = numberGenerator.getRandomNumber();
        if (randomInt > CAR_MOVE_BOUND) {
            moveCount++;
        }
    }

    public static List<Car> generateCars(int carSize, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car(numberGenerator));
        }
        return cars;
    }
}
