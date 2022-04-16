package study.step3;

import java.util.Random;

public class Racingcar {
    private int successCount;

    public int getSuccessCount() {
        return successCount;
    }

    public int tryToMoveForward() {
        int randomValue = new Random().nextInt(10);
        if (4 <= randomValue) {
            successCount++;
        }
        return randomValue;
    }
}
