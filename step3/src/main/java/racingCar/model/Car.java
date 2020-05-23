package main.java.racingCar.model;

import java.util.Random;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_CUT = 4;
    private static final int RANDOM_BOUND = 9;
    private int position;

    public Car(){
        position=DEFAULT_POSITION;
    }
    public int getPosition() {
        return position;
    }
    public void move(){
        int dice = new Random().nextInt(RANDOM_BOUND);
        position+= dice>=RANDOM_CUT?1:0;
    }
}
