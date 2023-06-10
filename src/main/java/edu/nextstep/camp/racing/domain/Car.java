package edu.nextstep.camp.racing.domain;

public class Car {

    private static final int MOVING_MIN_VALUE = 4;
    private static final int MOVING_MAX_VALUE = 9 ;
    private final String name;

    private int position = 0;
    public Car(String name) {
        this.name = name;
    }

    public void move(int randomInt) {
        if (MOVING_MAX_VALUE >= randomInt && randomInt >= MOVING_MIN_VALUE){
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }
}
