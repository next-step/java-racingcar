package race;

import java.util.Random;

public class CarRandomNumber implements RandomNumber {

    private final static int RANDOM_RANGE = 10;
    private final static int FORWARD_NUMBER = 4;
    private final static Random RANDOM = new Random();

    @Override
    public boolean isForward() {
        if (RANDOM.nextInt(RANDOM_RANGE) >= FORWARD_NUMBER) {
            return true;
        }
        return false;
    }
}
