package step3;

import java.util.Objects;

public class RacingCount {

    public final int count;
    public final static String VALID_MSG_RACING_COUNT = "시도할 횟 수는 1이상이여야 합니다.";

    public RacingCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(VALID_MSG_RACING_COUNT);
        }
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacingCount)) return false;
        RacingCount that = (RacingCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
