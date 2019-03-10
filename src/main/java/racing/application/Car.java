package racing.application;

import java.util.Random;

public class Car {
    private final int BOUND = 9;
    private final int CONDITION = 4;

    private int position = 1;

    protected int move() {
        if (canMove()) {
            return ++position;
        }

        return position;
    }

    protected boolean canMove() {
        return new Random().nextInt(BOUND) >= CONDITION;
    }

    public int getPosition() {
        return position;
    }
}
