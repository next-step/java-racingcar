package racingCar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    static private final int THRESHOLD = 10;
    static Random random = new Random();

    private RandomNumberGenerator() {

    }

    static public int getRandomNumber(){
        return random.nextInt(THRESHOLD);
    }
}
