package racingcar;

public class Count {

    private final int count;

    public Count(String rawCount) {
        int count = validateInteger(rawCount);
        this.count = count;
    }

    public Count(int count) {
        validatePositive(count);
        this.count = count;
    }

    private int validateInteger(String rawCount) {
        try {
            String trimmedCount = rawCount.trim();

            int convertedCount = Integer.parseInt(trimmedCount);
            validatePositive(convertedCount);

            return convertedCount;
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
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
