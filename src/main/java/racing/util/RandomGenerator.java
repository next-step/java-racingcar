package racing.util;

import java.util.Random;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class RandomGenerator {

    private static final Random RANDOM = new Random();

    public static int generate(int bound) {
        if (bound < 1) {
            throw new IllegalArgumentException("1보다 작은 값은 사용할 수 없습니다.");
        }
        return RANDOM.nextInt(bound);
    }
}
