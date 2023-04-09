package racingcar.support;

import racingcar.util.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generator() {
        return number;
    }
}
