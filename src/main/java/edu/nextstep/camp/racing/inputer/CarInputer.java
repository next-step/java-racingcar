package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;

public class CarInputer {

    private static final int MAX_CAR = 20;
    private static final int MIN_CAR = 2;

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
            throw new IllegalArgumentException("Please input a number between "+MIN_CAR+" and "+MAX_CAR);
        }
    }

    private boolean isInRange(int num) {
        return MAX_CAR >= num && num >= MIN_CAR;
    }
}
