package step2.racing.random;

public class StubRandomGenerator implements RandomGenerator {

    private int fixedNumber;

    public StubRandomGenerator(int fixedNumber) {

        this.fixedNumber = fixedNumber;
    }

    @Override
    public int getRandomIntValue(int bound) {

        if (bound <= fixedNumber) {
            throw new IllegalArgumentException("bound 값은 fixedNumber 보다 커야 합니다");
        }

        return fixedNumber;
    }
}
