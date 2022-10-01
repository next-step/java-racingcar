package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCount {
    public static final int MIN_COUNT = 1;

    private final int count;

    public CarCount(int count) {
        validateCountOverMinimum(count);
        this.count = count;
    }

    private void validateCountOverMinimum(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("자동차 한대 이상이 필요합니다.");
        }
    }
}
