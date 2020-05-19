package step3;

import java.util.Random;

public class Car {
    private final Random random = new Random();
    private final int DECIDE_NUM = 4;
    private int distance = 0;

    public void move(DecideMode mode) {
        moveSelectMode(mode);
    }

    public void move() {
        moveSelectMode(DecideMode.RANDOM_MODE);
    }

    private void moveSelectMode(DecideMode mode) {
        if(decideForward(mode)) {
            distance++;
        }
    }

    public boolean decideForward(DecideMode mode) {
        if(DecideMode.RANDOM_MODE == mode){
            return random.nextInt(10) > DECIDE_NUM;
        }
        return DecideMode.TRUE_RETURN_MODE == mode;
    }

    public int getDistance() {
        return distance;
    }

    public enum DecideMode {
        RANDOM_MODE,
        TRUE_RETURN_MODE,
        FALSE_RETURN_MODE
    }
}
