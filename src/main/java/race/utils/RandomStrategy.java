package race.utils;

import java.util.Random;

public class RandomStrategy implements PlayStrategy {

    private static final Random RANDOM = new Random();
    private static final int END_BOUND = 10;
    private static final int STANDARD_BOUND = 4;

    @Override
    public boolean isValidForGoForward() {
        return RANDOM.nextInt(END_BOUND) >= STANDARD_BOUND;
    }

}
