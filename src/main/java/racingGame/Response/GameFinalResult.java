package racingGame.Response;

import java.util.List;

public class GameFinalResult {

    private final List<GameResult> gameResult;
    private final List<String> winners;

    public GameFinalResult(List<GameResult> gameResult, List<String> winners) {
        this.gameResult = gameResult;
        this.winners = winners;
    }

    public List<GameResult> showFinalResult() {
        return gameResult;
    }

    public List<String> showFinalWinners() {
        return winners;
    }

}
