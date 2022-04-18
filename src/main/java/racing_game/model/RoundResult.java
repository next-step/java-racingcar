package racing_game.model;

import racing_game.domain.RacingCar;
import racing_game.util.Roulette;

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

    public void record(RacingCar racingCar) {
        this.roundResult.put(racingCar.getName(), racingCar.stopOrForward(Roulette.spin()).symbol);
    }

    public void record(RoundResult roundResult) {
        this.roundResult.putAll(roundResult.getRoundResult());
    }
}
