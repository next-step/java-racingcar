package step05.domain;

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
}
