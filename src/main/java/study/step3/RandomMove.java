package study.step3;

import study.step3.util.NumberGenerator;

public class RandomMove implements MoveStrategy{
    private static final int MAX_VALUE = 10;

    @Override
    public int getValue() {
        return NumberGenerator.randomVal(MAX_VALUE);
    }
}
