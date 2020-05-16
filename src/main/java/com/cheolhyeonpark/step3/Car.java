package com.cheolhyeonpark.step3;

public class Car {

    public static final int START_POSITION = 0;
    public static final String POSITION_BAR = "-";

    private int position = START_POSITION;

    public void move() {
        this.position++;
    }

    public void printPosition() {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_BAR);
        }
        System.out.println();
    }
}
