package study.step3.util;

import java.util.Random;

/**
 * 랜덤값 생성기
 */
public class NumberGenerator {
    private static final int RANDOM_MAX_LIMIT = 9;

    private NumberGenerator() {
    }

    public static int randomVal(int maxValue) {
        Random random = new Random();

        int num = random.nextInt(maxValue);
        if (num > RANDOM_MAX_LIMIT) {
            throw new IllegalArgumentException("Please change the maxValue");
        }

        return num;
    }
}
