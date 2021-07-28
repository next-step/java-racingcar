package racingCar;

import java.util.Random;

public class RandomNumberGenerator {
    static private final int THRESHOLD = 10;
    static Random random = new Random();

    static public int getRandomNumber(){
        return random.nextInt(THRESHOLD);
    }
}
