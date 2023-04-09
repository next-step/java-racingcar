package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;

public class MovingInputer extends PositiveNumInputer {

    private static final int MAX_MOVING = 200;
    private static final int MIN_MOVING = 10;

    @Override
    protected int maxNum() {
        return MAX_MOVING;
    }

    @Override
    protected int minNum() {
        return MIN_MOVING;
    }
}
