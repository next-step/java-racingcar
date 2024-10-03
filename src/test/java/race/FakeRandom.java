package race;

import java.util.Random;

public class FakeRandom extends Random {
    private final int fixedValue;

    public FakeRandom(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int nextInt(int bound) {
        return fixedValue;
    }
}
