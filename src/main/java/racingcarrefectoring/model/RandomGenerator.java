package racingcarrefectoring.model;

import java.util.Random;

public class RandomGenerator {

    private static final int LIMIT = 10;

    public static int getRandomNumber(){
        return new Random().nextInt(LIMIT);
    }
}
