package racing.domain;

public class Count {
    private final int value;

    public Count(String value) {
        this.value = toInt(value);
    }

    public int getValue() {
        return value;
    }

    private int toInt(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException();
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (isZeroOrNegativeNumber(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private boolean isZeroOrNegativeNumber(int number) {
        return number <= 0;
    }
}
