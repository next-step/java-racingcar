package racing.domain;

public class NumberOfRound {
    private final int number;

    private NumberOfRound(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        this.number = number;
    }

    public static NumberOfRound of(final int number) {
        return new NumberOfRound(number);
    }

    public int getNumber() {
        return number;
    }
}
