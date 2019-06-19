/*
 * ClassName : Car.java
 *
 * Version : 1.0
 *
 * Create Date : 2019.06.17
 *
 * Creator : 신익수
 *
 */
package com.iksoo.step3;

public class Car {
    private String carName;
    private String carPosition;
    private int currentDistance;

    Car(String name) {
        this.carName = name;
        this.carPosition = "";
        this.currentDistance = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarPosition() {
        return this.carPosition;
    }

    public void setCarPosition(String position) {
        this.carPosition = position;
    }

    public int getCurrentDistance() {
        int sumDistance = 0;
        for (int i = 0; i < this.carPosition.length(); i++) {
            sumDistance += Character.getNumericValue(this.carPosition.charAt(i));
        }

        return sumDistance;
    }
}
