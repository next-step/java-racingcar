package racingcarNew.domain;

import java.util.Random;

public class Utils {
    private static final int RANDOM_BOUND = 10;

    public int getRandomNo() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

}
