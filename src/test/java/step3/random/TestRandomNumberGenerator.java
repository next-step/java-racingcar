package step3.random;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private final int fixedNumber;

    public TestRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }

}
