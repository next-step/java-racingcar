package racingcar.domain;

public class GameResultInfo {

    private final NumberOfAttempts leftNumberOfAttempts;
    private final String gameResult;

    public GameResultInfo(NumberOfAttempts leftNumberOfAttempts, String gameResult) {
        this.leftNumberOfAttempts = leftNumberOfAttempts;
        this.gameResult = gameResult;
    }

    public NumberOfAttempts getLeftNumberOfAttempts() {
        return leftNumberOfAttempts;
    }

    public String getGameResult() {
        return gameResult;
    }
}
