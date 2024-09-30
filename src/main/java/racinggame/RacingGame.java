package racinggame;

public class RacingGame {

    private int round;

    public RacingGame() {
        this.round = 1;
    }

    public int getRound() {
        return round;
    }

    public void start(int carCount, int tryCount) {
        validateNegative(carCount, tryCount);
        for (int i = 0; i < tryCount; i++) {
            validateNextRound(tryCount);
        }
    }

    private void validateNegative(int carCount, int tryCount) {
        if (carCount <= 0 || tryCount <= 0) {
            throw new RuntimeException("음수가 전달되어 게임을 시작할 수 없습니다.");
        }
    }

    private void validateNextRound(int tryCount) {
        if (isNextRound(tryCount)) {
            round++;
        }
    }

    private boolean isNextRound(int tryCount) {
        return round < tryCount;
    }
}
