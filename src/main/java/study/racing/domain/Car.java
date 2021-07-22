package study.racing.domain;

import static study.racing.common.Common.createRandomNumber;

public class Car {

    private static final int LIMIT_NUMBER = 4;

    private Distance distance;

    public Car() {
        distance = new Distance();
    }

    public static Car createCar() {
        return new Car();
    }

    public Distance getDistance() {
        return distance;
    }

    public static Boolean checkMoveableCar() {
        return createRandomNumber() >= LIMIT_NUMBER;
    }

    public void moveTheCar() {
        if(checkMoveableCar()){
            distance.move();
        }
    }
}
