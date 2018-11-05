package racing.rule;

import java.util.Random;

public class Forward implements IForward {

    private static final int MAX_SCORE = 10;
    private static final int MIN_SCORE = 3;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isPossible() {
        return RANDOM.nextInt(MAX_SCORE) > MIN_SCORE;
    }

}
