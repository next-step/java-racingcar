package step3.random;

public class TestRandomNumberGenerator implements RandomNumberGenerator{
    private final int fixedNumber;

    @Override
    public int generate() {
        return fixedNumber;
    }

    public TestRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

}
