package racing.domain;

import java.util.List;

public class GameResult {
    private final List<Integer> roundResult;

    private GameResult(List<Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public List<Integer> getRoundResult() {
        return roundResult;
    }

    public static GameResult save(List<Integer> roundResult) {
        return new GameResult(roundResult);
    }
}
