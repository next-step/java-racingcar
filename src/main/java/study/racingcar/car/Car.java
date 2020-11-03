package study.racingcar.car;

import study.racingcar.car.moving.CarMovingStrategy;
import study.racingcar.car.moving.MovingSeed;

public class Car {

    int currentPosition;
    CarMovingStrategy carMovingStrategy;

    public Car(CarMovingStrategy carMovingStrategy) {
        this.currentPosition = 0;
        this.carMovingStrategy = carMovingStrategy;
    }

    public void move() {

        MovingSeed movingSeed = carMovingStrategy.getMovingSeed();

        if (movingSeed.isMovable()) {
            goForward();
        }
    }

    public void goForward() {
        this.currentPosition += 1;
    }

    public void stop() {
        this.currentPosition += 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
