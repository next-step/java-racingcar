package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;

public abstract class PositiveNumInputer {

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

    protected abstract int maxNum();

    protected abstract int minNum();

    private void checkInRangeByResultNum(int resultNum) {
        if (!isInRange(resultNum)) {
            throw new IllegalArgumentException("Please input a number between " + maxNum() + " and " + minNum());
        }
    }

    private boolean isInRange(int num) {
        return maxNum() >= num && num >= minNum();
    }
}
