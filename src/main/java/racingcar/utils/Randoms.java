package racingcar.utils;

import java.util.Random;

public class Randoms {

    private static final Random RANDOM = new Random();

    private Randoms() {}

    public static int getRandomIntWithinRange(final int start, final int end) {
        validateRange(start, end);
        return start + RANDOM.nextInt(end - start + 1);
    }

    private static void validateRange(final int start, final int end) {
        if (end == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("끝값이 너무 큽니다.");
        }

        if (end - start >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("입력값이 너무 큽니다.");
        }

        if (start > end) {
            throw new IllegalArgumentException("start가 end보다 클 수 없습니다.");
        }
    }
}
