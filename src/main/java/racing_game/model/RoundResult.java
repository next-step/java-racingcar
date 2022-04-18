package racing_game.model;

import racing_game.util.Behavior;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoundResult {

    private final Map<String, String> roundResult;

    public RoundResult() {
        this.roundResult = new LinkedHashMap<>();
    }

    public Map<String, String> getRoundResult() {
        return this.roundResult;
    }

    public void record(String racingCarId, Behavior behavior) {
        this.roundResult.put(racingCarId, behavior.symbol);
    }

    public void record(RoundResult roundResult) {
        this.roundResult.putAll(roundResult.getRoundResult());
    }
}
