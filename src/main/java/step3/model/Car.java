package step3.model;

import java.util.Random;

public class Car {

    private final int INIT_POSITION = 0;
    private final Random random = new Random();

    private final int MOVE_BOUNDARY = 4;

    private int position;

    public Car() {
        position = INIT_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void move(int movePoint){
        if(moveForward(movePoint)){
            position++;
        }
    }

    private boolean moveForward(int movePoint) {
        if(movePoint < 0){
            throw new IllegalArgumentException("0 보다 작은수");
        }
        return movePoint >= MOVE_BOUNDARY;
    }
}
