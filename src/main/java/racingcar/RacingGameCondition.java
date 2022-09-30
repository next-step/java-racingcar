package racingcar;

public class RacingGameCondition {

    private final int racingCarCount;
    private final int gameTurnCount;

    public RacingGameCondition(int racingCarCount, int gameTurnCount) {
        this.racingCarCount = racingCarCount;
        this.gameTurnCount = gameTurnCount;
    }

    public int getRacingCarCount() {
        return racingCarCount;
    }

    public int getGameTurnCount() {
        return gameTurnCount;
    }
}
