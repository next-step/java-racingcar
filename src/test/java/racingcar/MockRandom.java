package racingcar;

import java.util.Random;

public class MockRandom extends Random {
    private final int value;

    public MockRandom(int value) {
        this.value = value;
    }

    @Override
    public int nextInt(int bound) {
        return value;
    }
}
