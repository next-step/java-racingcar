package racingCar;

import sun.jvm.hotspot.utilities.AssertionFailure;

import java.util.Random;

public class RandomNumberGenerator {
    static private final int THRESHOLD = 10;
    static Random random = new Random();

    private RandomNumberGenerator() {
        throw new AssertionFailure();
    }

    static public int getRandomNumber(){
        return random.nextInt(THRESHOLD);
    }
}
