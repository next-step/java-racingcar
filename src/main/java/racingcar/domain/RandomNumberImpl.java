package racingcar.domain;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber {
    public static final int UPPER_BOUND = 10;
    
    private static Random random = new Random();

    @Override
    public int getInt() {
        return random.nextInt(UPPER_BOUND);
    }

}
