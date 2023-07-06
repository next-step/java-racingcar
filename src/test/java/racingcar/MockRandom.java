package racingcar;

import java.util.Random;

public class MockRandom extends Random {

    private final int randomNumber;

    public MockRandom (int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public int nextInt(int bound) {
        return randomNumber;
    }
}
