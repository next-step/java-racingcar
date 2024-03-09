package racing.domain;

public class AttemptCount {
    private final int numberOfAttempt;

    public AttemptCount(String input) {
        this.numberOfAttempt = toInt(input);
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
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
