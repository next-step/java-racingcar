package step3.study.domain;

import step3.study.util.Validator;

public class RequestRacingDTO {
    private final int carCount;
    private final int tryCount;

    public RequestRacingDTO(String carCount, String tryCount) {
        this.carCount = Validator.numberCheck(carCount);
        this.tryCount = Validator.numberCheck(tryCount);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
