package study.step3;

import step3.common.NumberGenerator;

public class FixNumberGenerator implements NumberGenerator {
    private final int number;

    public FixNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
