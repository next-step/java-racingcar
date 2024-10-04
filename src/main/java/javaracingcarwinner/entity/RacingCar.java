package javaracingcarwinner.entity;

import java.util.Random;

public class RacingCar {

    private static final int DEFAULT_LOCATION = 0;
    private static final int DEFAULT_MOVE_VALUE = 1;
    private static final int MIN_STANDARDS_VALUE = 4;
    private static final int MAX_STANDARDS_VALUE = 9;
    private static final int RANDOM_RANGE = 10;
    private static final Random random = new Random();


    private final String name;

    private int location;

    public RacingCar(String name) {
        this(name, DEFAULT_LOCATION);
    }

    public RacingCar(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(){
        if(isMove(random.nextInt(RANDOM_RANGE))){
            go();
        }
    }

    private RacingCar go() {
        location += DEFAULT_MOVE_VALUE;
        return this;
    }

    public boolean isMove(int value) {
        return MIN_STANDARDS_VALUE <= value && value <= MAX_STANDARDS_VALUE;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }
}
