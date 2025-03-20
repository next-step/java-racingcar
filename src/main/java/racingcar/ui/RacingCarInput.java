package racingcar.ui;

import calculator.StringCalculator;

public class RacingCarInput {

    private final String carNameCsv;
    private final int tryCount;

    public RacingCarInput(String carNameCsv, int tryCount) {
        this.carNameCsv = carNameCsv;
        this.tryCount = tryCount;
        this.validate();
    }

    public String getCarNameCsv() {
        return carNameCsv;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate() {
        if (StringCalculator.isBlank(carNameCsv)) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        if (this.tryCount < 2) {
            throw new IllegalArgumentException("시도 횟수는 2 이상이어야 합니다.");
        }
    }
}
