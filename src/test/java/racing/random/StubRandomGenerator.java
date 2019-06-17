package racing.random;

public class StubRandomGenerator implements RandomGenerator {

    private int fixedNumber;

    public StubRandomGenerator(int fixedNumber) {

        this.fixedNumber = fixedNumber;
    }

    @Override
    public int getRandomIntValue() {

        return fixedNumber;
    }
}
