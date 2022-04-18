package racingversion2.car.util;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random random = new Random();

    public static int generateRandomValue(){
        return random.nextInt(10);
    }

}
