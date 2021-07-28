package edu.nextstep.racingcar.step4.domain;

public class Car {

    private int distance = 1;
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public CarName getCarName() {
        return carName;
    }
}
