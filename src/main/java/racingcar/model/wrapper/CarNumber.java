package racingcar.model.wrapper;

import racingcar.exception.CarNumberException;

public class CarNumber {
    private final int number;

    public CarNumber(int number) {
        if (number < 1) {
            throw new CarNumberException("자동차 대수는 1대 이상이어야 합니다.");
        }
        this.number = number;
    }

    public boolean isGreaterThan(int compare) {
        return number > compare;
    }
}
