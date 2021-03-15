package step5.utils;

import java.util.Random;

public class RandomGenerator extends Random{

    public static final int RANDOM_RANGE = 9;

    public int getRandomNum() {
        return super.nextInt(RANDOM_RANGE);
    }

}
