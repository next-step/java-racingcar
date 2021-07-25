package step3.domain;

import java.util.List;
import java.util.Map;
import step3.runType.RunStrategy;
import step3.ui.InputView;

public class GameSetting {

    private int carCount;
    private int roundCount;
    private RunStrategy runStrategy;

    public GameSetting(Map<String, Integer> userInputs, RunStrategy runStrategy) {
        this.carCount = userInputs.get(InputView.CAR_COUNT_KEY);
        this.roundCount = userInputs.get(InputView.ROUND_COUNT_KEY);
        this.runStrategy = runStrategy;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public RunStrategy getRunStrategy() {
        return runStrategy;
    }
}
