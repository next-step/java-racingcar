package game.racing.domain;

import java.util.Random;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class RandomGenerator {

    private static final int BOUND = 10;
    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(BOUND);
    }

}
