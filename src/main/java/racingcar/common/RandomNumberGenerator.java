package racingcar.common;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_BOUNDARY = 10;
    private static Random random = new Random();
    private static RandomNumberGenerator instance;

    private RandomNumberGenerator(){}

    public static RandomNumberGenerator getInstance(){
        if(instance == null)
            instance = new RandomNumberGenerator();

        return instance;
    }

    public static int generate(){
        return random.nextInt(MAX_BOUNDARY);
    }
}
