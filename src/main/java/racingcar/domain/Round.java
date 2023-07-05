package racingcar.domain;

public class Round {

    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        validate(round);
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
            throw new RuntimeException("라운드는 0 이하가 될 수 없습니다.");
        }
    }
}
