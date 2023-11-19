package racingcar.domain;

import java.util.Objects;

public class NumberOfAttempts {
    private final long number;

    public NumberOfAttempts(long number) {
        this.number = number;
    }

    public NumberOfAttempts attempt() {
        return new NumberOfAttempts(this.number - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberOfAttempts that = (NumberOfAttempts) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
