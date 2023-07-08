package racingcar;

public class Count {

    private final int count;

    public Count(String count) {
        String trimmedCount = count.trim();

        try {
            int converted = Integer.parseInt(trimmedCount);

            validatePositive(converted);

            this.count = converted;
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Count(int count) {
        validatePositive(count);
        this.count = count;
    }

    private void validatePositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Count tryOnce() {
        return new Count(this.count - 1);
    }

    public boolean isRemaining() {
        return this.count > 0;
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
        return count;
    }

}
