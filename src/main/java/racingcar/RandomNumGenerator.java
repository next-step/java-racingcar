package racingcar;

import java.util.Random;

public class RandomNumGenerator implements NumGenerator {

    private static int RANDOM_RANGE = 10;
    private Random random = new Random();

    @Override
    public int getNextInt() {
        return random.nextInt(RANDOM_RANGE);
    }
}
