package racingcar.domain;

public class Round {

    private static final String MIN_NUMBER_FORAMT = "라운드 횟수는 %s번 이상이여야 합니다.";
    private static final int MIN_NUMBER = 1;

    private final int number;

    public Round(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_NUMBER_FORAMT, MIN_NUMBER));
        }
    }

    public int getNumber() {
        return number;
    }
}
