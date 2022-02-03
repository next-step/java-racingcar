package racingcar.util;

import java.util.Random;
import racingcar.view.RacingCarOutput;

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
            throw new IllegalArgumentException(RacingCarOutput.ERROR_RANDOM_NUMBER_MAX_OVERFLOW);
        }

        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(RacingCarOutput.ERROR_RANDOM_NUMBER_MAX_LIMIT);
        }

        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(RacingCarOutput.ERROR_START_NOT_BIG_END);
        }
    }
}
