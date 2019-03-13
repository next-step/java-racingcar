package racingcar.domain;

import racingcar.utils.RandomGenerator;

public class TestRandomGenerator implements RandomGenerator {
    private int value;

    public TestRandomGenerator(int value) {
        this.value = value;
    }

    @Override
    public int getRandomValue() {
        return this.value;
    }
}
