package racinggame;

public class FakeRandomGenerator implements RandomGenerator {

    private final int fixedNumber;

    public FakeRandomGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int nextInt() {
        return this.fixedNumber;
    }
}
