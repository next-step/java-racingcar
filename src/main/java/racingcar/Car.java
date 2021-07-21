package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final static int GO_VALUE = 4;
    private int moveSpace;

    public Car(int moveSpace) {
        this.moveSpace = moveSpace;
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

    public static List<Car> createCars(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

}
