package racingcar.common;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_BOUNDARY = 10;
    private static Random random = new Random();

    public static int generate(){
        return random.nextInt(MAX_BOUNDARY);
    }
}
