package racingcar.racinggame;

import java.util.Objects;

public class Count {
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final int MIN_COUNT = 0;
    private int count;

    public Count(final String value) {
        validate(value);
        this.count = toInt(value);
    }

    private int toInt(final String value) {
        return Integer.parseInt(value);
    }

    void validate(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new RuntimeException("실행 횟수는 양수만 가능합니다");
        }
    }

    public boolean isRunning() {
        return count > MIN_COUNT;
    }

    public void run() {
        count--;
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
