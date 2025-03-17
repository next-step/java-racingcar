package racingcar;

import java.util.Random;

public class RandomForTest extends Random {

    private final int returnNumber;

    RandomForTest(int returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public int nextInt(int bound) {
        return returnNumber;
    }
}
