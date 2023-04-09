package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;

public class MovingInputer {

    private static final int MAX_MOVING = 200;
    private static final int MIN_MOVING = 10;

    public InputPositiveResult input() {
        try {
            InputPositiveResult positiveResult = new InputPositiveResult(InputView.input());
            checkInRangeByResultNum(positiveResult.result());
            InputView.close();
            return positiveResult;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return input();
        }
    }

    private void checkInRangeByResultNum(int resultNum) {
        if (!isInRange(resultNum)) {
            throw new IllegalArgumentException("Please input a number between "+ MIN_MOVING +" and "+ MAX_MOVING);
        }
    }

    private boolean isInRange(int num) {
        return MAX_MOVING >= num && num >= MIN_MOVING;
    }
}
