package racingcar;

import static java.text.MessageFormat.format;

public final class Racing {

    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차의 대수는 자연수만 가능합니다. [carCount : {0}]";
    private static final String INVALID_PLAYING_COUNT_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int ZERO = 0;

    private Racing() {
    }

    public static void race(final int carCount, final int playingCount) {
        if (carCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_CAR_COUNT_MESSAGE, carCount));
        }

        if (playingCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_PLAYING_COUNT_MESSAGE, playingCount));
        }
    }
}
