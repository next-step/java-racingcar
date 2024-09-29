package racingcar.model;

import racingcar.exception.ForwardException;
import racingcar.model.enums.Status;

import java.util.Objects;

public class Forward {
    private final Status status;

    public Forward(int number) {
        if (number < 0 || number > 9) {
            throw new ForwardException("0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.");
        }
        this.status = Status.extractByNumber(number);
    }

    protected Forward(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward forward = (Forward) o;
        return status == forward.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
