package step3.domain;

public class GameRound {
    private static final int MINIMUM_ROUND = 0;

    private int round;

    private GameRound() {
    }

    private GameRound(int round) {
        validateIsMinimum(round);
        this.round = round;
    }

    public static GameRound create(int round) {
        return new GameRound(round);
    }

    public void next() {
        round--;
    }

    public boolean isEnd() {
        return round < MINIMUM_ROUND;
    }

    public int getRound() {
        return round;
    }

    private void validateIsMinimum(int round) {
        if (round <= MINIMUM_ROUND) {
            throw new IllegalArgumentException("시도 회수는 0보다 큰 값을 입력해 주세요");
        }
    }
}
