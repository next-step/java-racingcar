package racingcar.mock;

import racingcar.RandomUtil;

public class MockAlwaysMaxValueRandomUtil implements RandomUtil {
    @Override
    public int getInt(int bound) {
        return bound - 1;
    }
}
