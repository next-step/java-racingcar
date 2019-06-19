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

    Car(String name, int totalInning) {
        this.inning = 0;
        this.carName = name;
        this.carPosition = new String[totalInning];
    }

    public String getCarName() {
        return this.carName;
    }

    public int getTotalInning() {
        return this.carPosition.length;
    }

    public void addNextInning(int random, int criterion) {
        this.carPosition[this.inning] = random >= criterion ? "1" : "0";
        this.inning++;
        printInningResult();
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
