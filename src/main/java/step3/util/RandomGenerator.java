package step3.util;

import java.util.Random;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class RandomGenerator {

    private static final Random RANDOM = new Random();

    public static int generate(int min, int max) {
        validRange(min, max);
        return randomOnRange(min, max);
    }

    private static void validRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("최소 숫자가 최대 숫자보다 클 수 없습니다.");
        }
        if (min == max) {
            throw new IllegalArgumentException("min와 max의 값이 같을 수 없습니다.");
        }
    }

    private static int randomOnRange(int min, int max) {
        int range = Math.abs(max + 1 - min);
        return RANDOM.nextInt(range) + min;
    }
}
