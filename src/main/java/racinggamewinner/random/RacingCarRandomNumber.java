package racinggamewinner.random;

import java.util.Random;

public class RacingCarRandomNumber implements NumberGenerator {
    @Override
    public int executeStrategy() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
