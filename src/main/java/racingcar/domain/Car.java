/*
 *   Class name : Car.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar.domain;

/**
 * 해당 클래스는 Racing의 필요한 Car 객채입니다.
 */
public class Car {

    public static final int FORWARD_RANGE = 10;
    public static final int FORWARD_MIN_NUMBER = 4;
    private String carName;
    private int currentLocation;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int currentLocation) {
        this.carName = carName;
        this.currentLocation = currentLocation;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getCarName() {
        return carName;
    }

    /**
     * 무작위의 숫자가 4보다 크다면 이동합니다.
     */
    public void moveCar(int move) {
        if (move >= FORWARD_MIN_NUMBER) {
            this.currentLocation = (this.currentLocation + move);
        }
    }
}
