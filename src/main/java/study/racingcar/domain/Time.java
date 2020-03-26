package study.racingcar.domain;

import java.util.Objects;

public class Time {
    private static final int MIN = 1;
    private int time;

    public Time(int time) {
        if (time < MIN) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %d 이상이여야 합니다.", MIN));
        }
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time1 = (Time) o;
        return time == time1.time;
    }

    @Override public int hashCode() {
        return Objects.hash(time);
    }
}
