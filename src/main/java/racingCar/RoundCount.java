package racingCar;

import java.util.Objects;

public class RoundCount {
    private final int count;

    public RoundCount(){
        this(0);
    }

    public RoundCount(int count) {
        this.count = count;
    }

    public int value() {
        return this.count;
    }

    public RoundCount decrease() {
        return new RoundCount(this.count - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

    @Override
    public String toString() {
        return "RoundCount{" +
                "count=" + count +
                '}';
    }
}
