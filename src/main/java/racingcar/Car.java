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
    private String carName;
    private int currentLocation = 0;
    private final int minLocation = 3;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * 자동차가 이동할 무작위 숫자를 반환합니다.
     * @return
     */
    public int getMove(int range) {
        Random moveIndex = new Random();
        int move = moveIndex.nextInt(range);
        return move;
    }

    /**
     * 무작위의 숫자가 4보다 크다면 이동합니다.
     */
    public void moveCar(int range) {

        int move = getMove(range);
        if(move > minLocation) {
            this.setCurrentLocation(this.getCurrentLocation() + move);
        }
    }
}
