package study.racing.domain;

public class TryCounts {

    private static final int MIN_NUMBER = 1;
    private final int value;

    public TryCounts(String value) {

        int number = parseTryCount(value);
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("시도할 회수는 1 이상 이어야 합니다.");
        }
        this.value = number;
    }

    private int parseTryCount(String value) {

        int number;
        try {
            number = Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException("시도할 회수는 숫자여야 합니다.");
        }
        return number;
    }
}
