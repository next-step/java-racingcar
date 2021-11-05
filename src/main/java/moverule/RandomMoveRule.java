package moverule;

import car.Car;

import java.util.Random;

public class RandomMoveRule implements MoveRule {

    private static final Random random = new Random();
    private static final int FORWARD_COUNT = 1;

    public void move(Car car){
        if(isForward()) car.forward(FORWARD_COUNT);
    }

    private boolean isForward() {
        return random.nextInt(10) >= 4;
    }
}