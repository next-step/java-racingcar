package racinggame.domain;

import racinggame.domain.strategy.RandomHolder;

public class TestRandomHolder implements RandomHolder {

    private final int number;

    public TestRandomHolder(int number) {
        this.number = number;
    }

    @Override
    public int nextInt() {
        return this.number;
    }
}
