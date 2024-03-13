package racing.util;

public class FixedNumberGeneratorImpl implements RandomNumberGenerator {

    private final int fixedNumber;

    public FixedNumberGeneratorImpl(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int getRandomNumber(int bound) {
        return fixedNumber;
    }
}
