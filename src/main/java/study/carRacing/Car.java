package study.carRacing;

import java.util.Random;

public class Car {

    public int carNumber;
    public int movingDistance;

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.movingDistance = 0;
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public void move(int distance) {
        this.movingDistance += distance;
    }
}
