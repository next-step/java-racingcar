package racingcar.domain;

public class Round {
    private static final String NOT_POSITIVE_MESSAGE = "라운드는 음수가 될 수 없습니다.";
    private int round;

    private Round(int round) {
        validate(round);
        this.round = round;
    }

    public static Round from(int round) {
        return new Round(round);
    }

    public int getRound() {
        return round;
    }

    public void decrease() {
        validate(this.round);
        this.round--;
    }

    private static void validate(int round) {
        if (round <= 0) {
            throw new RuntimeException(NOT_POSITIVE_MESSAGE);
        }
    }
}
