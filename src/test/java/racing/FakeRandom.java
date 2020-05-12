package racing;

import java.util.Random;

public class FakeRandom extends Random {
    private int randomValue;

    public FakeRandom(int randomValue) {
        this.randomValue = randomValue;
    }

    @Override
    public int nextInt(int bound) {
        return this.randomValue;
    }
}
