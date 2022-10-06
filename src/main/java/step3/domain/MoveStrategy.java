package step3.domain;

import java.util.Random;

public class MoveStrategy implements MovableStrategy {

    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();
    private static final int CAN_MOVE_NUMBER = 4;

    @Override
    public boolean isMove() {
        return RANDOM_NUMBER.randomNumber() > CAN_MOVE_NUMBER;
    }
}
