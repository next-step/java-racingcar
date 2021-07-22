package step3.model;

import step3.RacingApp;
import step3.view.ToDash;

import java.util.Random;

public class Car {

    private final int INIT_POSITION = 0;
    private final Random random = new Random();

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
        return movePoint >= RacingApp.MOVE_BOUNDARY;
    }

    @Override
    public String toString() {
        return ToDash.positionToDash(position);
    }
}
