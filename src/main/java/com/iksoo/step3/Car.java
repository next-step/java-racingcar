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
    private int inning;
    private String carName;
    private String[] carPosition;

    Car(String name) {
        this.inning = 0;
        this.carName = name;
    }

    public String getCarName() {
        return this.carName;
    }

    public void addNextInning(String position) {
        this.carPosition[this.inning] += position;
        this.inning++;
    }

    public int getFinalPosition() {
        int finalPosition = 0;

        for (int i = 0; i < this.inning; i++) {
            finalPosition += this.carPosition[i].equals("1") ? 1 : 0;
        }

        return finalPosition;
    }

    public void printInningResult() {
        String result = "";

        for (int i = 0; i < this.inning; i++) {
            result += this.carPosition[i].equals("1") ? "-" : "";
        }

        System.out.println(this.carName + " : " + result);
    }
}
