package racingcar.model.wrapper;

import racingcar.exception.ForwardStatusException;
import racingcar.model.enums.Status;

import java.util.Objects;

import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;

public class ForwardStatus {
    public static final String NOT_ALLOWED_BETWEEN_ZERO_TO_NINE = "0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.";
    private final int number;

    public ForwardStatus(int number) {
        if (isInvalidNumber(number)) {
            throw new ForwardStatusException(NOT_ALLOWED_BETWEEN_ZERO_TO_NINE);
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        return number < 0 ||
                number > 9;
    }

    public Status status() {
        if (isForwardNumber()) {
            return FORWARD;
        }
        return STOP;
    }

    private boolean isForwardNumber() {
        return this.number >= 4 &&
                this.number <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForwardStatus that = (ForwardStatus) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
