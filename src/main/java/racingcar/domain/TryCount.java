package racingcar.domain;

public class TryCount {

    private int count;

    public TryCount(int count) {
        this.count = count;
    }

    public void executeGame() {
        this.count--;
    }

    public boolean hasTryCount() {
        return this.count > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TryCount tryCount = (TryCount) o;

        return count == tryCount.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
