package javaracingcar.entity;

public class RacingCar {

    private int carId;
    private int moveCount;

    public RacingCar(int carId) {
        this.carId = carId;
        this.moveCount = 0;
    }

    public void go() {
        this.moveCount += 1;
    }

    public int moveCount() {
        return this.moveCount;
    }

}
