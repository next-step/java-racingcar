/*
 *   Class name : Car.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingCar;

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
}
