package racingcar.model.wrapper;

import racingcar.exception.MovementNumberException;

public class MovementNumber {
    public static final String NOT_ALLOWED_BELOW_ONE = "이동 횟수는 1 이상이어야 합니다.";
    private final int number;

    public MovementNumber(int number) {
        if (number < 1) {
            throw new MovementNumberException(NOT_ALLOWED_BELOW_ONE);
        }
        this.number = number;
    }

    public boolean isGreaterThan(int compare) {
        return this.number > compare;
    }

    @Override
    public String toString() {
        return "MovementNumber{" +
                "number=" + number +
                '}';
    }
}
