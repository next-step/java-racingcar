package racingcarfinal.domain;

public class Rounds {

    private static final int MIN_ROUND_COUNT = 0;

    private int roundCount;

    public Rounds(int roundCount) {
        validate(roundCount);
        this.roundCount = roundCount;
    }

    private void validate(int roundCount) {
        if (roundCount < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("round 수는 0 미만일 수 없습니다.");
        }
    }

    public boolean isEnd() {
        return roundCount <= MIN_ROUND_COUNT;
    }

    public void play() {
        if (roundCount <= MIN_ROUND_COUNT) {
            throw new IllegalStateException("모든 round가 끝났습니다.");
        }
        roundCount--;
    }

}
