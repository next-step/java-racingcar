package racinggamewinner;

import racinggamewinner.random.RandomGenerator;

public class AlwaysMoveNumber implements RandomGenerator {

    public static final int TEST_MOVING_NUMBER = 4;

    @Override
    public int generateRandomNumber() {
        return TEST_MOVING_NUMBER;
    }
}
