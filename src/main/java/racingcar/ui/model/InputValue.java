package racingcar.ui.model;

import racingcar.utils.Preconditions;

public class InputValue {
    private static final int LIMIT_COUNT = 0;
    private Integer carCount;
    private Integer retryCount;

    private InputValue(Integer carCount, Integer retryCount) {
        Preconditions.checkNotNull(carCount, "carCount required not null");
        Preconditions.checkNotNull(retryCount, "retryCount required not null");
        Preconditions.checkNumber(carCount, LIMIT_COUNT, String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", LIMIT_COUNT));
        Preconditions.checkNumber(retryCount, LIMIT_COUNT, String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", LIMIT_COUNT));

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
