package racingcar.domain.game;

public class RoundInfo {

    private static final int DEFAULT_RACING_ROUND = 0;
    private final int totalGameRound;
    private int racingRound;

    public RoundInfo(int totalGameRound) {
        validateGameRound(totalGameRound);

        this.totalGameRound = totalGameRound;
        this.racingRound = DEFAULT_RACING_ROUND;
    }

    public boolean isEndGame() {
        return this.totalGameRound == this.racingRound;
    }

    public void increaseRound() {
        this.racingRound++;
    }

    private void validateGameRound(int totalGameRound) {
        if (totalGameRound <= 0) {
            throw new IllegalArgumentException("최소 1번 이상의 게임을 진행해야 합니다.");
        }
    }
}
