package carracing.step3;

import java.util.Random;

public class Car {

    private final StringBuilder moveTrace;

    public Car() {
        this.moveTrace = new StringBuilder();
    }

    public void move() {
        int randomNumber = new Random().nextInt(10);
        if(randomNumber > 4) {
            moveTrace.append("-");
        }
    }

    public String moveTrace() {
        return moveTrace.toString();
    }

}
