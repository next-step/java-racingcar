package racingcar.domain;

public class Round {
    private final int round;

    public Round(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("라운드는 음수가 될 수 없습니다");
        }
    }

    public Round decreaseRound() {
        return new Round(round - 1);
    }
}
