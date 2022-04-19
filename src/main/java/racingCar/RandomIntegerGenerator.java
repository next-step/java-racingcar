package racingCar;

import java.util.Random;

public class RandomIntegerGenerator implements IntegerGeneratorStrategy {
    static Random random = new Random();
    static final int BOUND = 10;

    public int generate() {
        return random.nextInt(BOUND);
    }
}
