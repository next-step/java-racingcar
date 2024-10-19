package racinggamewinner;

import racinggamewinner.random.NumberGenerator;

public class AlwaysMoveNumber implements NumberGenerator {

    public static final int TEST_MOVING_NUMBER = 4;

    @Override
    public int executeStrategy() {
        return TEST_MOVING_NUMBER;
    }
}
