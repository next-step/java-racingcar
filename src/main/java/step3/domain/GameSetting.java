package step3.domain;

import java.util.List;
import java.util.Map;
import step3.runType.RunStrategy;
import step3.ui.InputView;

public class GameSetting {

    public static final int CAR_COUNT_INDEX = 0;
    public static final int ROUND_COUNT_INDEX = 1;

    private int carCount;
    private int roundCount;
    private RunStrategy runStrategy;

    public GameSetting(List<String> userInputs, RunStrategy runStrategy) {
        this.carCount = getInt(userInputs.get(CAR_COUNT_INDEX));
        this.roundCount = getInt(userInputs.get(ROUND_COUNT_INDEX));
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

    private int getInt(String string) {
        return Integer.parseInt(string);
    }
}
