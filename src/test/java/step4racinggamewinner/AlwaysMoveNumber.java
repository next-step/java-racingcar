package step4racinggamewinner;

import step4racinggamewinner.random.RandomGenerator;

public class AlwaysMoveNumber implements RandomGenerator {
    @Override
    public int generateRandomNumber() {
        return 4;
    }
}
