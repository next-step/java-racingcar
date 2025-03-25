package racingcar;

public class StubRandomNumberGenerator implements RandomNumberGenerator {
    private int fixedValue;

    public void setFixedValue(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate(int max) {
        return fixedValue;
    }
}
