package game.domain;

public class GameRound {

    private final int maxRound;
    private int currentRound;

    public GameRound(int maxRound) {
        validateMaxGameCount(maxRound);
        this.maxRound = maxRound;
    }

    private void validateMaxGameCount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    public boolean isDone() {
        return currentRound >= maxRound;
    }

    public void nextRound() {
        if (currentRound < maxRound) {
            currentRound++;
            return;
        }
        throw new IllegalStateException(String.format("currentRound(%d)가 maxRound(%d)입니다.", currentRound, maxRound));
    }

}