package racingcar.domain;

import racingcar.constant.InputExceptionMessage;

public class InputRoundCount {

    private int roundCount;

    public InputRoundCount(String value) {
        int roundCount = 0;
        try {
            roundCount = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
        }

        if (roundCount < 1) {
            throw new IllegalArgumentException(InputExceptionMessage.ONLY_POSITIVE);
        }

        this.roundCount = roundCount;
    }

}
