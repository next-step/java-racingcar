package racingcarfinal.domain;

public class Rounds {

    private int roundCount;

    public Rounds(int roundCount) {
        validate(roundCount);
        this.roundCount = roundCount;
    }

    private void validate(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException("round 수는 0 미만일 수 없습니다.");
        }
    }

    public boolean isEnd() {
        return roundCount <= 0;
    }

    public void play() {
        if (roundCount <= 0) {
            throw new IllegalStateException("모든 round가 끝났습니다.");
        }
        roundCount--;
    }

}
