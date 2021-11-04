package racingcar;

import java.util.Objects;

public class Status {
    private final int forwardCount;

    public Status() {
        this(0);
    }

    public Status(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public int value() {
        return this.forwardCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return forwardCount == status.forwardCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(forwardCount);
    }
}
