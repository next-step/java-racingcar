package racingcar.domain.random;

public class FixedRandomNumberGenerator implements RandomNumberGenerator {

    private final int fixedNumber;

    public FixedRandomNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public RandNum generate() {
        return new RandNum(fixedNumber);
    }
}
