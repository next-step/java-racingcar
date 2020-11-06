package study.racingcar.car;

import java.util.Random;

/**
 * 각 자동차에 대한 위치를 보관하는 책임
 */
public class Car {

    private int currentPosition = 1;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(Engine engine) {

        if (engine.isMovable()) {
            goForward();
        }

    }

    private void goForward() {
        this.currentPosition += 1;
    }



}
