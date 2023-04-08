package com.nextstep.racingcargame.core;

public class CarMover {

    private int carMovingNumber;

    protected CarMover(int generatedRandomNumber) {
        this.carMovingNumber = generatedRandomNumber;
    }

    public void moveCar(Car car) {
        car.moveForwardByNumber(carMovingNumber);
    }
}
