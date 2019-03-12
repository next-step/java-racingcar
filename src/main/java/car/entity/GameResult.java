package car.entity;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<RacingRound> allResult;

    private GameResult() {
        allResult = new ArrayList<>();
    }

    public static GameResult initGameResult() {
        return new GameResult();
    }

    public void pushGameResult(RacingRound racingRound) {
        allResult.add(racingRound);
    }

    public List<RacingRound> getAllResult() {
        return allResult;
    }
}
