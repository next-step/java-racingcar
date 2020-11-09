package racingcar;

import java.util.Random;

public class RandomGenerator {
    static final int RANDOM_RANGE = 10;
    static final Random random = new Random();


    public int getRandomNumber(){
        return random.nextInt(RANDOM_RANGE);
    }
}
