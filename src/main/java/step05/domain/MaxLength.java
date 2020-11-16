package step05.domain;

import java.util.Objects;

public class MaxLength {
    private final int maxLength;
    private static final int defaultMaxLength = 5;

    private MaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public static MaxLength of () {
        return new MaxLength(defaultMaxLength);
    }

    public static MaxLength of (int maxLength) {
        return new MaxLength(maxLength);
    }

    public boolean isOutOfBoundLength(String name) {
        return name.length() > maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxLength maxLength1 = (MaxLength) o;
        return maxLength == maxLength1.maxLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLength);
    }
}
