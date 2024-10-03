package racingcar.model;

public class Car {
    private final int carNumber;
    private int carMovingDistance;

    public Car(int carNumber, int carMovingDistance) {
        this.carNumber = carNumber;
        this.carMovingDistance = carMovingDistance;
    }

    public void move(boolean isCarMovingForward) {
        if(isCarMovingForward)
            carMovingDistance++;
    }

    public int getCarMovingDistance() {
        return this.carMovingDistance;
    }
}
