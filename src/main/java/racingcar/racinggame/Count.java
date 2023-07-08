package racingcar.domain;

import java.util.Objects;

public class Count {
    private final String NUMBER_PATTERN = "^[0-9]+$";
    private final int count;

    public Count(final String value) {
        validate(value);
        this.count = toInt(value);
    }

    public Count(int count) {
        this.count = count;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

    void validate(String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new RuntimeException("실행 횟수는 양수만 가능합니다");
        }
    }

    public boolean isRunning() {
        return count > 0;
    }

    public Count run() {
        return new Count(count - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
