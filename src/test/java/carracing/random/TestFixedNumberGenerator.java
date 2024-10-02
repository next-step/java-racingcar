package carracing.random;

import carracing.domain.random.RandomNumberGenerator;

public class TestFixedNumberGenerator implements RandomNumberGenerator {
    private final int fixedNumber;

    public TestFixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }

}
