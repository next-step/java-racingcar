package car_racing;

import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int INITIAL_COUNT = 0;
    private static final int CAR_MOVE_BOUND = 4;
    private static final int MAX_CAR_NAME = 5;
    private final String name;
    private int moveCount = INITIAL_COUNT;

    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    void moveOrStop() {
        int randomInt = numberGenerator.getRandomNumber();
        if (randomInt > CAR_MOVE_BOUND) {
            moveCount++;
        }
    }

    public static List<Car> generateCars(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
        return cars;
    }

    public static Boolean isExceed5Characters(String carName) {
        return carName.length() > MAX_CAR_NAME;
    }
}
