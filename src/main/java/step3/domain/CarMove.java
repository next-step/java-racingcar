package step3.domain;

import java.util.Random;

public class CarMove {
    Random random = new Random();

    int MINIMUM_REQUIRED_VALUE = 4;
    int MAX_INITIALIZE_VALUE = 10;

    public boolean checkMovable() {
        return random.nextInt(MAX_INITIALIZE_VALUE) >= MINIMUM_REQUIRED_VALUE;
    }

}
