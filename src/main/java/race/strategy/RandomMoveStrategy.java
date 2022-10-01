package race.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_STANDARD_NUMBER = 4;

    @Override
    public boolean movable() {
        int randomNumber = makeRandomNumber();
        return randomNumber >= MOVE_STANDARD_NUMBER;
    }

    private int makeRandomNumber() {
        return new Random().nextInt(10);
    }
}
