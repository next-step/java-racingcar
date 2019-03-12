package racingcar;

import java.util.Random;

public class RacingUtil {

    public static int generateRandomNum(int bound) {
        Random random = new Random();

        return random.nextInt(bound);
    }

}
