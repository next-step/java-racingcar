package step3.util;

import java.util.Random;

public class RandomIntegerGeneratorUtil {

    private static final Random RANDOM = new Random();
    private static final int MAX = 10;

    private RandomIntegerGeneratorUtil() {
        throw new RuntimeException("유틸성 클래스입니다.");
    }

    public static int generate() {
        return RANDOM.nextInt(MAX);
    }
}
