package racing.domain;

import java.text.MessageFormat;

public class Car {
    private static final int MIN_RESULT = 0;
    final static int MAX_RESULT = 9;

    private int location;

    public int getLocation() {
        return location;
    }

    public void run(final int result) {
        if (result < MIN_RESULT || result > MAX_RESULT) {
            throw new IllegalArgumentException(MessageFormat.format("{0} ~ {1}사이의 결과값이어야 합니다.", MIN_RESULT, MAX_RESULT));
        }

        if (result >= 4) {
            location++;
        }
    }
}
