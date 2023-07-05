package racingcar;

import racingcar.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private int value;
    public FixedNumberGenerator(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}
