package racinggamewinner.random;

import java.util.Random;

public class RacingCarRandomNumber implements NumberGenerator {
    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
