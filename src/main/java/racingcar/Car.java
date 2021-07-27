/*
 *   Class name : Car.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import java.util.Random;

/**
 * 해당 클래스는 Racing의 필요한 Car 객채입니다.
 */
public class Car {
    private int currentLocation = 0;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * 자동차가 이동할 무작위 숫자를 반환합니다.
     * @return
     */
    public int getMove() {
        Random moveIndex = new Random();
        int move = moveIndex.nextInt(10);
        return move;
    }

    /**
     * 무작위의 숫자가 4보다 크다면 이동합니다.
     */
    public void moveCar() {
        int move = getMove();
        if(move > 3) {
            this.setCurrentLocation(this.getCurrentLocation() + move);
        }
    }
}
