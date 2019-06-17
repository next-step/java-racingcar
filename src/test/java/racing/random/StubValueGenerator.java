package racing.random;

public class StubValueGenerator implements ValueGenerator {

    private int fixedNumber;

    public StubValueGenerator(int fixedNumber) {

        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateIntValue() {

        return fixedNumber;
    }
}
