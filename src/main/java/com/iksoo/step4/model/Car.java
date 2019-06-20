package com.iksoo.step4.model;

public class Car {
    private final int GOSTOP_CRITERION = 4;

    private int inning;
    private String carName;
    private String[] carPosition;

    public Car(String name, int totalInning) {
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

    public void doRacing(int random) {
        this.carPosition[this.inning] = random >= GOSTOP_CRITERION ? "1" : "0";
        this.inning++;
    }

    public String getRanHistory(int inning) {
        String result = this.carName + " : ";
        for (int i = 0; i < inning; i++) {
            result += this.carPosition[i].equals("1") ? "-" : "";
        }

        return result;
    }

    public boolean isVictory(int maxDistance) {
        return this.getFinalPosition() == maxDistance ? true : false;
    }

    public int getFinalPosition() {
        int finalPosition = 0;
        for (int i = 0; i < this.inning; i++) {
            finalPosition += this.carPosition[i].equals("1") ? 1 : 0;
        }

        return finalPosition;
    }
}
