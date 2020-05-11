package racing.utils;

import java.util.Random;

public class RandomTestUtils extends Random {

    private int returnValue;

    public RandomTestUtils(int returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public int nextInt(int bound) {
        return this.returnValue;
    }
}
