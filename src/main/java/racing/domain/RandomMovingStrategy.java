package racing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVE_MIN_NUMBER = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(10) >= MOVE_MIN_NUMBER;
    }

    public static MovingStrategy isMove(int diceNumber) {
        return diceNumber >= MOVE_MIN_NUMBER ? new AlwaysMoveMovingStrategy() : new AlwaysStopMovingStrategy();
    }
}
