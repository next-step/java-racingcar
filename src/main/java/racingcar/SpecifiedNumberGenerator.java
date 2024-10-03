package racingcar;

public class SpecifiedNumberGenerator implements NumberGenerator {

    private final int fixedNumber;

    public SpecifiedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}
