package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<Integer> carStatus = new ArrayList<>();
    private int numberOfCar;

    public List<Integer> getCarStatus() {
        return this.carStatus;
    }

    public void setCarStatus(List<Integer> carStatus) {
        this.carStatus = carStatus;
    }

    public int getNumberOfCar() {
        return this.numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

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
