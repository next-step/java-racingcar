package carracing.step3;

import java.util.Random;

public class Car {

    private final StringBuilder moveTrace;
    private final int MOVE_FORWARD_BORDER = 4;

    public Car() {
        this.moveTrace = new StringBuilder();
    }

    public void move() {
        int randomNumber = new Random().nextInt(10);
        if (randomNumber > MOVE_FORWARD_BORDER) {
            moveTrace.append("-");
        }
    }

    public String moveTrace() {
        return moveTrace.toString();
    }

}
