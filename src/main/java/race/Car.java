package race;

import java.util.Random;

public class Car {

    private int forwardResult = 1;
    private static final int randomRange = 10;

    public int getConditionNumber() {
        return new Random().nextInt(randomRange);
    }

    public void forward(int conditionNumber) {
        if (conditionNumber >= 4) {
            forwardResult++;
        }
    }

    public int getForwardResult() {
        return forwardResult;
    }
}
