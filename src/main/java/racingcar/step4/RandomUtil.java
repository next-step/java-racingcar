package racingcar.step4;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    private static final int BOUNDARY = 10;

    public static int generateRandomNumber(){
        return random.nextInt(BOUNDARY);
    }
}
