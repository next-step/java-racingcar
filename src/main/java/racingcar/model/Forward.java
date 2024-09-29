package racingcar.model;

import racingcar.exception.ForwardException;

import java.util.Objects;

public class Forward {
    private final int number;

    public Forward(int number) {
        if (number < 0 || number > 9) {
            throw new ForwardException("0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward that = (Forward) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
