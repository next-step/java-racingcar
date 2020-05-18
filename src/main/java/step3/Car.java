package step3;

import java.util.Random;

public class Car {
    private final Random random = new Random();
    private final int DECIDE_NUM = 4;
    private int distance = 0;

    public void move() {
        if (decideForward()) {
            distance++;
        }
    }

    private boolean decideForward() {
        return random.nextInt(10) > DECIDE_NUM;
    }

    public int getDistance() {
        return distance;
    }
}
