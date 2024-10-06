package racingcar.mock;

import racingcar.domain.RandomHolder;

public class TestRandomHolder implements RandomHolder {

    private final int number;

    public TestRandomHolder(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
