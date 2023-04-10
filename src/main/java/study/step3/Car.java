package study.step3;

import java.util.Random;

public class Car {
    private StringBuilder move;
    private static final Random random  = new Random();
    private static final int STARTING_CONDITION = 4;
    private static final int RANDOM_RANGE = 10;
    private static final String MOVE = "-";

    Car() {
        move = new StringBuilder();
    }

    public void calcMove() {
        moveCar(isMove(random.nextInt(RANDOM_RANGE)));
    }

    public Boolean isMove(int input) {
        if (input >= STARTING_CONDITION) {
            return true;
        }
        return false;
    }

    public void moveCar(boolean moveResult) {
        if (moveResult) {
            move.append(MOVE);
        }
    }

    public String getMoveValue() {
        return move.toString();
    }
}
