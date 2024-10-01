package racing.domain;

import java.util.List;
import racing.model.CarInfo;

public class GameResult {
    private final List<CarInfo> roundResult;

    private GameResult(List<CarInfo> roundResult) {
        this.roundResult = roundResult;
    }

    public List<CarInfo> getRoundResult() {
        return roundResult;
    }

    public static GameResult save(List<CarInfo> roundResult) {
        return new GameResult(roundResult);
    }
}
