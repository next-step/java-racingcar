package racingcar.util;

// Test double that always returns a fixed number, to control move/stop deterministically.
public class FixedRandomGenerator extends RandomGenerator {

    private final int fixedNumber;

    public FixedRandomGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumber(int bound) {
        return fixedNumber;
    }
}