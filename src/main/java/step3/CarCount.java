package step3;

import java.util.Objects;

public class CarCount {

    public final int count;
    public final static String VALID_MSG_CAR_COUNT = "자동차 대수는 1이상이여야 합니다.";

    public CarCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(VALID_MSG_CAR_COUNT);
        }
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarCount)) return false;
        CarCount carCount = (CarCount) o;
        return count == carCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
