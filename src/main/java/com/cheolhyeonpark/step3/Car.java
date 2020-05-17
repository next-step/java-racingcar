package com.cheolhyeonpark.step3;

public class Car {

    public static final int START_POSITION = 0;

    private int position = START_POSITION;

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
