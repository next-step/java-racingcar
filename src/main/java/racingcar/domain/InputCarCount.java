package racingcar.domain;

import racingcar.constant.InputExceptionMessage;

public class InputCarCount {

    private int carCount;

    public InputCarCount(String value) {
        int carCount = 0;
        try {
            carCount = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(InputExceptionMessage.INVALID_NUMBER_FORMAT);

        }

        if (carCount < 1) {
            throw new IllegalArgumentException(InputExceptionMessage.ONLY_POSITIVE);
        }

        this.carCount = carCount;
    }

}
