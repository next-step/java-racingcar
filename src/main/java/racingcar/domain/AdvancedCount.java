package racingcar.domain;

public class AdvancedCount {
    private int count;

    public AdvancedCount() {
        this.count = 0;
    }
    public AdvancedCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void add() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvancedCount that = (AdvancedCount) o;

        return count == that.count;
    }

    @Override
    public int hashCode() {
        return count;
    }

}
