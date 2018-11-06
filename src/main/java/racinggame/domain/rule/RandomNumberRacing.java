package racinggame.domain.rule;

import java.util.Random;

public class RandomNumberRacing implements RacingRule {
    private final Random number = new Random();
    private static final int POSSIBLE_NUMBER = 4;
    private static final int MAX_NUMBER = 9;

    @Override
    public boolean isPossibleMove() {
        return  number.nextInt(MAX_NUMBER) >= POSSIBLE_NUMBER;
    }

}
