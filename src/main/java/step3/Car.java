package step3;

import java.util.Random;

public class Car {
    private final Random random = new Random();

    public boolean decideForward() {
        int DECIDE_NUM = 4;
        return random.nextInt(10) > DECIDE_NUM;
    }
}
