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
    private static final int GOSTOP_CRITERION = 4;

    Car(String Name) {
        this.carName = Name;
        this.carPosition = "";
    }

    public boolean judgeGoOrStop(int number) {
        return number >= GOSTOP_CRITERION ? true : false;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarPosition() {
        return this.carPosition;
    }
}
