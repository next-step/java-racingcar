package winner;

import java.util.Random;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 01:20
 */
public class RandomValue {
    private static final Random random = new Random();

    public static int getInt(int bound) {
        return random.nextInt(bound);
    }
}
