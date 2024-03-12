package racingCar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 10;

    public int generate(){
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
