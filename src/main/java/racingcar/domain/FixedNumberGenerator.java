package racingcar.domain;

public class FixedNumberGenerator implements NumberGenerator {

    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
