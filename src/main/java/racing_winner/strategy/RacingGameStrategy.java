package racing_winner.strategy;

import java.util.Random;

public class RacingGameStrategy implements RacingStrategy{

    private static final int RACING_MOVE_RULE = 4;
    private static final int RANDOM_NUMBER_MAX = 10;
    private static final Random RANDOM_NUMBER = new Random();

    @Override
    public boolean isMovable() {
        return randomNumber() >= RACING_MOVE_RULE;
    }

    private int randomNumber() {
        return RANDOM_NUMBER.nextInt(RANDOM_NUMBER_MAX);
    }
}
