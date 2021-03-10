package racingcar.domain;

public class GameRound {

    private static final int ZERO = 0;
    private int round;

    public GameRound(int round) {
        validateLessThanZero(round);
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void validateLessThanZero(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException("0이하의 값인지 확인해주세요.");
        }
    }
}
