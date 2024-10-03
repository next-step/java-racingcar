package racingcar.model;

public class Car {
    int carNumber;
    public String currentCarMovingStatus;

    public Car(int carNumber, String currentMovingStatus) {
        this.carNumber = carNumber;
        this.currentCarMovingStatus = currentMovingStatus;
    }
}
