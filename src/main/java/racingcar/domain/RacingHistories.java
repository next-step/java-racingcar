package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingHistories {
    private final List<RacingHistory> value;

    private RacingHistories(List<RacingHistory> histories) {
        this.value = histories;
    }

    public static RacingHistories valueOf(List<RacingHistory> histories) {
        return new RacingHistories(histories);
    }

    public List<RacingHistory> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingHistories that = (RacingHistories) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
