package racingcar.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("끝값이 너무 큽니다. (스택 오버플로우 발생이 가능합니다)");
        }

        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("입력값이 너무 큽니다.");
        }

        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive가 endInclusive보다 클 수 없습니다.");
        }
    }
}
