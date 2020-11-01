package racingcar.mock;

import racingcar.util.RandomUtil;

public class MockAlwaysMaxValueRandomUtil implements RandomUtil {
    @Override
    public int getInt(int bound) {
        return bound - 1;
    }
}
