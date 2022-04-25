package study.step4.util;

import study.step3.MoveStrategy;

public class TestMove implements MoveStrategy {
    private int value;

    public TestMove(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
