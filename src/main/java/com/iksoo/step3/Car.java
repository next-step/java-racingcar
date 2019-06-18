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
    public String carPosition;
    public int maxDistance;

    Car(String Name) {
        this.carName = Name;
        this.carPosition = "";
        this.maxDistance = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarPosition() {
        return this.carPosition;
    }
}
