package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;

public class CarInputer extends PositiveNumInputer {

    private static final int MAX_CAR = 20;
    private static final int MIN_CAR = 2;

    @Override
    protected int maxNum() {
        return MAX_CAR;
    }

    @Override
    protected int minNum() {
        return MIN_CAR;
    }
}
