package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    List<Integer> carStatus = new ArrayList<>();
    int numberOfCar;

    public Car(int numberOfCar) {
        this.numberOfCar = numberOfCar;
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.add(i, 0);
        }
    }

    public List<Integer> carMovingNum(List<Integer> goStop) {
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.set(i, carStatus.get(i) + goStop.get(i));
        }
        return carStatus;
    }
}
