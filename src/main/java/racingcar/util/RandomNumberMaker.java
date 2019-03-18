package racingcar.util;

import java.util.Random;

public class RandomNumberMaker {

    public static int generate(final int bound) {
        Random random = new Random();

        return random.nextInt(bound);
    }

}
