package racingcar;

public class Round {

    private static int MIN_NUMBER = 1;

    private final int number;

    public Round(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("라운드 횟수는 " + MIN_NUMBER + "번 이상이여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
