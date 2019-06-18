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
    public int carPosition;

    Car(String Name) {
        this.carName = Name;
        this.carPosition = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }
}
