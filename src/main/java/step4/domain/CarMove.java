package step4.domain;

import java.util.Random;

public class CarMove {
    private static final Random random = new Random();

    private static final int MINIMUM_REQUIRED_VALUE = 4;
    private static final int MAX_INITIALIZE_VALUE = 10;

    public boolean checkMovable() {
        return random.nextInt(MAX_INITIALIZE_VALUE) >= MINIMUM_REQUIRED_VALUE;
    }

}
