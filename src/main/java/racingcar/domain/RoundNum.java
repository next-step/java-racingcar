package racingcar.domain;

public class RoundNum {
    public static final int MIN_ROUND_NUM = 0;
    private static final int ROUND_OVER_NUM = 0;

    private final int roundNum;

    public RoundNum(int roundNum) {
        checkValidRoundNum(roundNum);
        this.roundNum = roundNum;
    }

    private void checkValidRoundNum(int roundNum) {
        if (roundNum < MIN_ROUND_NUM) {
            throw new IllegalArgumentException("유효하지 않은 round number 입니다.");
        }
    }

    RoundNum runOneRound() {
        return new RoundNum(roundNum - 1);
    }

    boolean isRoundOver() {
        return roundNum == ROUND_OVER_NUM;
    }
}
