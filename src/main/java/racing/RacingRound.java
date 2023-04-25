package racing;

public class RacingRound {
    private final int round;

    public RacingRound(int inputTryCount) {
        validatePositve(inputTryCount);
        this.round = inputTryCount;
    }

    private void validatePositve(int inputTryCount) {
        if (inputTryCount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
