package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int GO_VALUE = 4;
    private final String name;

    private int moveSpace;

    public Car(String name, int moveSpace) {
        this.name = name;
        this.moveSpace = moveSpace;
    }

    public static List<Car> createCars(String[] carNames, int carNumber) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car(carNames[i], 0));
        }
        return cars;
    }

    public int getMoveSpace() {
        return moveSpace;
    }

    public int advanceOrStop(int randomValue) {
        if(randomValue >= GO_VALUE) {
            return 1;
        }
        return 0;
    }

    public int move(int randomValue) {
        moveSpace += advanceOrStop(randomValue);
        return moveSpace;
    }

    public String getName() {
        return name;
    }
}
