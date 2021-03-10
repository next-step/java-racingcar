package step3.study.domain;

import step3.study.util.Validator;

public class RequestRacingDTO {
    private final int carCount;
    private final int tryCount;

    public RequestRacingDTO(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
