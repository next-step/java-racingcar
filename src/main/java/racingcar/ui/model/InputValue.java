package racingcar.ui.model;

import racingcar.utils.Preconditions;

public class InputValue {
    private Integer carCount;
    private Integer retryCount;

    private InputValue(Integer carCount, Integer retryCount) {
        Preconditions.checkNotNull(carCount, "carCount required not null");
        Preconditions.checkNotNull(retryCount, "retryCount required not null");

        this.carCount = carCount;
        this.retryCount = retryCount;
    }

    public static InputValue of(Integer carCount, Integer retryCount) {
        return new InputValue(carCount, retryCount);
    }

    public Integer getCarCount() {
        return carCount;
    }

    public Integer getRetryCount() {
        return retryCount;
    }
}
