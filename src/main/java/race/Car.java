package race;

import java.util.Random;

public class Car {

    private int forwardResult = 1;
    private RandomNumber conditionNumber;

    public Car(RandomNumber randomNumber) {
        this.conditionNumber = randomNumber;
    }

    public int getConditionNumber() {
        return conditionNumber.randomNumber();
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
