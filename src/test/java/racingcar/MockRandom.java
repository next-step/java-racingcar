package racingcar;

import java.util.Random;

class MockRandom extends Random {
    private static int nextInt;

    public static void setNextInt(int value) {
        nextInt = value;
    }

    @Override
    public int nextInt(int bound) {
        return nextInt;
    }
}