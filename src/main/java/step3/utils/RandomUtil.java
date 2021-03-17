package step3.utils;

import java.util.Random;

public class RandomUtil implements NumberGenerator {

    private static final int BOUND_OF_RANDOM_NUM = 10;

    @Override
    public int getRandom() {
        return new Random().nextInt(BOUND_OF_RANDOM_NUM);
    }
}
