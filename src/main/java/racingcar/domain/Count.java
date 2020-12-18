package racingcar.domain;

import racingcar.util.ValidateUtils;

public class Count {
    private static final String VALID_MIN_COUNT = "주어진 횟수는 최소 1번입니다.";

    private int count = 0;

    public Count(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (ValidateUtils.validateMin(count)) {
            throw new IllegalArgumentException(VALID_MIN_COUNT);
        }
    }

    public int getCount() {
        return this.count;
    }
}
