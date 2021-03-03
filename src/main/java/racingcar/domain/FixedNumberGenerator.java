package racingcar.domain;

public class FixedNumberGenerator implements NumberGenerator {

    private final int NUMBER;

    public FixedNumberGenerator(int number) {
        NUMBER = number;
    }

    @Override
    public int generate() {
        return NUMBER;
    }
}
