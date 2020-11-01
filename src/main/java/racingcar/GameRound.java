package racingcar;

public class GameRound {
    private int round;

    public GameRound(int round) {
        this.round = round;
    }

    public void endRound() {
        round--;
    }

    public boolean isGameEnd() {
        return round == 0;
    }
}
