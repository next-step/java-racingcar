package racingcar.domain;

public class TryCount {

    private static final int MIN_COUNT = 1;

    private final int tryCount;

    public TryCount(String number) {
        this.tryCount = parseNumberIfValid(number);
        if (isNotInRage(this.tryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private int parseNumberIfValid(String number) {
        if (number.matches("\\d+")) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException();
    }

    private boolean isNotInRage(int number) {
        return number < MIN_COUNT;
    }

    public int getTryCount() {
        return tryCount;
    }
}
